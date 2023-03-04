package ps.백준.바킹독.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 선긋기_2170 {

    public static int n;
    public static int[][] lines;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        lines = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, (int[] a, int[] b) ->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int minPoint = lines[0][0];
        int maxPoint = lines[0][1];


        for (int i = 1; i < n; i++) {
            int[] line = lines[i];
            if (line[0] > maxPoint) {
                answer += (maxPoint - minPoint);
                minPoint = line[0];
                maxPoint = line[1];
                continue;
            }
            if (line[1] > maxPoint) {
                maxPoint = line[1];
            }
        }

        answer += maxPoint - minPoint;

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
