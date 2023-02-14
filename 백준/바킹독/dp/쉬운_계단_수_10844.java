package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 쉬운_계단_수_10844 {
    public static int n,tc;
    public static long dp[][];
    public static long answer = 0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        if(n==1) {
            answer=9;
        } else if (n == 2) {
            answer=17;
        }
        else{
            dp = new long[n][10];
            Arrays.fill(dp[0],1);
            dp[0][0]=0;
            Arrays.fill(dp[1], 2);
            dp[1][0]=1;
            dp[1][1]=1;
            dp[1][9]=1;

            for(int i=2; i<n;i++){
                for (int j = 0; j < 10; j++) {
                    if(j==0){
                        dp[i][j]=dp[i-1][1];
                        continue;
                    }
                    if(j==9){
                        dp[i][j]=dp[i-1][8];
                        continue;
                    }
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
                }
            }
            for (int i = 0; i < 10; i++) {
                answer = (answer+dp[n-1][i])%1000000000;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
