package ps.백준.바킹독.우선순위큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드_정렬하기_1715 {

    public static int n, m;
    public static int[] arr;
    public static PriorityQueue<Integer> pq;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        pq = new PriorityQueue<>();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while (pq.size() != 1) {
            int op1 = pq.poll();
            int op2 = pq.poll();
            int sum = op1+op2;
            answer += sum;
            pq.offer(sum);
        }

        System.out.println(answer);
    }
}
