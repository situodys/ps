package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1로_만들기2_12852 {

    public static int[] dp;
    public static int[] visited;
    public static int n;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        visited = new int[n+1];

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+1;
            visited[i] = i - 1;
            if( i%3==0){
                if(dp[i/3]+1 < dp[i]){
                    dp[i] = dp[i/3]+1;
                    visited[i] = i/3;
                }
            }
            if( i%2==0){
                if(dp[i/2]+1  < dp[i]){
                    dp[i]= dp[i/2]+1;
                    visited[i] = i/2;
                }
            }
        }

        bw.write(dp[n] + "\n");
        while(n>0){
            bw.write(String.valueOf(n) + ' ');
            n=visited[n];
        }
        bw.flush();
        bw.close();
    }
}
