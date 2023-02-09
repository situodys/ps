package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1로_만들기_1463 {

    public static int[] dp;
    public static int n;
    public static int answer;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+1;
            if( i%3==0) dp[i] = Math.min(dp[i/3]+1,dp[i]);
            if( i%2==0) dp[i] = Math.min(dp[i/2]+1,dp[i]);
        }

        System.out.println(dp[n]);
    }
}
