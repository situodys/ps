package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2xn_타일링_11726 {

    public static int n;
    public static int dp[] = new int[1000];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp[0]= 1;
        dp[1]=2;

        for(int i=2; i<n;i++){
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }

        System.out.println(dp[n - 1]);
    }
}
