package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 피보나치_함수_1003 {
    public static int[][] dp = new int[41][2];
    public static int t,n;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;
        for(int i=2 ; i<=40; i++){
            dp[i][0]=dp[i-2][0]+dp[i-1][0];
            dp[i][1]=dp[i-2][1]+dp[i-1][1];
        }

        while(t-->0){
            n = Integer.parseInt(br.readLine());
            bw.write(""+dp[n][0] + ' ' + dp[n][1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
