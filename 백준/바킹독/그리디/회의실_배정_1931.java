package ps.백준.바킹독.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실_배정_1931 {
    public static int n,k,answer=0;
    public static int[][] timeTable;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        timeTable = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeTable, (int[] a, int[] b) -> {
            if(a[1]==b[1])
                return a[0]-b[0];
            return a[1] - b[1];
        });

        int curEnd=0;
        for (int i = 0; i < n; i++) {
            if(curEnd> timeTable[i][0]) continue;
            answer++;
            curEnd = timeTable[i][1];
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }
}
