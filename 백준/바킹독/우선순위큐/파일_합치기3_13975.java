package ps.백준.바킹독.우선순위큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파일_합치기3_13975 {

    public static int n, m;
    public static int[] arr;
    public static PriorityQueue<Long> pq;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            answer =0;
            pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            while (pq.size() >1) {
                long op1 = pq.poll();
                long op2 = pq.poll();
                long sum = op1+op2;
                answer += sum;
                pq.offer(sum);
            }
            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }
}
