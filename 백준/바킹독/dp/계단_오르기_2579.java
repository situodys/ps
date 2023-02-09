package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 계단_오르기_2579 {
    public static int[] dp=new int[300];
    public static int[] stairs = new int[300];
    public static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1]= stairs[0]+stairs[1];
        dp[2]= stairs[2] + Math.max(dp[0],stairs[1]);
        for(int i=3 ;i< n;i++){
            dp[i] = Math.max(dp[i - 2] , dp[i - 3] + stairs[i - 1])+stairs[i];
        }

        System.out.println(dp[n-1]);
    }
}
