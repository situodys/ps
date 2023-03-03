package ps.백준.바킹독.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실_배정_11000 {
    public static int n, t;
    public static int[][] timeTable;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        timeTable = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeTable, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(timeTable[0][1]);
        for (int i = 1; i < n; i++) {
            int[] cur = timeTable[i];
            if (cur[0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(cur[1]);
        }

        bw.write(pq.size()+"");
        bw.flush();
        bw.close();
    }
}
