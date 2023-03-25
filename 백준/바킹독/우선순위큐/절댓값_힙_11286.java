package ps.백준.바킹독.우선순위큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절댓값_힙_11286 {

    public static int n, m;
    public static int[] arr;
    public static PriorityQueue<Integer> pq;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer = 1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (cur != 0) {
                pq.offer(cur);
                continue;
            }
            if (pq.isEmpty()) {
                sb.append(0).append('\n');
                continue;
            }
            sb.append(pq.poll()).append('\n');
        }
        System.out.println(sb);
    }
}
}
