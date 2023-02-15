package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 제곱수의_합_1699_R {

    public static int n;
    public static int dp[];
    public static int answer = 100001;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        for (int i = 1; i <=n ; i++) {
            dp[i]=i;
            for(int j =1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
}
