package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0_3151 {

    public static int n;
    public static int[] skillLevels;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer= 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        skillLevels = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            skillLevels[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(skillLevels);

        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                int ub = upperBound(j,-skillLevels[i] - skillLevels[j]);
                int lb = lowerBound( j,-skillLevels[i] - skillLevels[j]);
                answer += ub-lb;
            }
        }

        bw.write(""+answer);
        bw.flush();
        bw.close();
    }

    private static int lowerBound(int start,int x) {
        int st=start,en =skillLevels.length;

        while (st + 1 < en) {
            int mid = (st+en)/2;
            if(skillLevels[mid] <x) st=mid;
            else en =mid;
        }
        return en;
    }

    private static int upperBound(int start,int x) {
        int st=start,en =skillLevels.length;

        while (st + 1 < en) {
            int mid = (st+en)/2;
            if(skillLevels[mid] <=x) st=mid;
            else en =mid;
        }
        return en;
    }
}
