package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 피보나치2_2748 {
    public static int t,n;
    public static long dp[];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        dp = new long[t+1];

        dp[1]=1;

        for(int i=2; i<=t;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        bw.write(String.valueOf(dp[t]));
        bw.flush();
        bw.close();
    }
}
