package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 이친수_2193 {
    public static int n;
    public static long dp[][] = new long[90][2];
    public static int answer;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp[0][0]=0;
        dp[0][1]=1;

        dp[1][0] = 1;
        dp[1][1] = 0;

        for(int i=2; i<n;i++){
            dp[i][0]= dp[i-1][0]+dp[i-1][1];
            dp[i][1]= dp[i-1][0];
        }

        bw.write(String.valueOf(dp[n-1][0]+dp[n-1][1]));
        bw.flush();
        bw.close();
    }
}
