package ps.백준.바킹독.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {
    public static int n,answer=0;
    public static int[] times;
    public static int[] dp;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        times= new int[n];
        dp= new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        dp[0]=times[0];
        for (int i = 1; i < n; i++) {
            dp[i]=dp[i-1]+times[i];
        }

        for (int sum : dp) {
            answer+=sum;
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }
}
