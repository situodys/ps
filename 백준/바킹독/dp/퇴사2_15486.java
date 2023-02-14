package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 퇴사2_15486 {
    public static int n,tc;
    public static int dp[];
    public static int periods[], pays[];
    public static boolean flag[];
    public static int answer = 0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new int[n];
        periods = new int[n];
        pays = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            periods[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }

        if (periods[n - 1] == 1) {
            dp[n-1]=pays[n-1];
        }
        for (int i = n-2; i >=0; i--) {
            int period= i+periods[i];
            if (period <= n) {
                dp[i] = Math.max((period==n ? 0:dp[period])+pays[i],dp[i+1]);
                continue;
            }
            dp[i]=dp[i+1];
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer,dp[i]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
