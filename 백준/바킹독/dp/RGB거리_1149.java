package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149 {
    public static int n;
    public static int colors[][] = new int[1000][3];
    public static int dp[][] = new int[1000][3];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = colors[0][0];
        dp[0][1] = colors[0][1];
        dp[0][2] = colors[0][2];

        for(int i=1 ; i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + colors[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + colors[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + colors[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]));
    }
}
