package ps.백준.바킹독.우선순위큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 가운데를_말해요_1655 {

    public static int n, m;
    public static int[] arr;
    public static PriorityQueue<Integer> large;
    public static PriorityQueue<Integer> small;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        large = new PriorityQueue<>();
        small = new PriorityQueue<>(Comparator.reverseOrder());

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (!small.isEmpty() && small.peek() < cur) {
                large.offer(cur);
                if (large.size() > small.size()) {
                    small.offer(large.poll());
                }
            } else {
                small.offer(cur);
                if (small.size() > large.size()+1) {
                    large.offer(small.poll());
                }
            }

            sb.append(small.peek()).append('\n');
        }

        System.out.println(sb);
    }
}
