package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2xn_타일링2_11727 {

    public static int n;
    public static int dp[] = new int[1000];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp[0]= 1;
        dp[1]=3;

        for(int i=2; i<n;i++){
            dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        }

        bw.write(String.valueOf(dp[n-1]));
        bw.flush();
        bw.close();
    }
}
