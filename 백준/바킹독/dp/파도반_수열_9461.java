package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 파도반_수열_9461 {

    public static int n,tc;
    public static long dp[];
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tc = Integer.parseInt(br.readLine());
        dp = new long[100];
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        dp[4]=2;

        while(tc-->0){
            n = Integer.parseInt(br.readLine());

            for(int i=5 ;i< n;i++){
                dp[i] = dp[i-3]+dp[i-2];
            }

            bw.write(String.valueOf(dp[n - 1]) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
