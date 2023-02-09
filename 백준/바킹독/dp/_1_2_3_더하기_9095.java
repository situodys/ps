package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1_2_3_더하기_9095 {
    public static int[] dp;
    public static int tc,n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());
        while(tc-- != 0){
            n = Integer.parseInt(br.readLine());
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            if (n == 2) {
                System.out.println(2);
                continue;
            }
            dp = new int[n+1];

            dp[1]=1; dp[2]= 2; dp[3]=4;
            for(int i=4; i<=n; i++){
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }

            System.out.println(dp[n]);
        }
    }
}
