package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LCS_9251_R {

    public static char[] first,second;
    public static int dp[][];
    public static long answer = 0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        first = br.readLine().toCharArray();
        second = br.readLine().toCharArray();

        dp = new int[first.length+1][second.length+1];

        for(int i=1; i<=first.length;i++){
            for (int j = 1; j <= second.length; j++) {
                if(first[i-1]==second[j-1]){
                    dp[i][j]= dp[i-1][j-1]+1;
                    continue;
                }
                dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        bw.write(String.valueOf(dp[first.length][second.length]));
        bw.flush();
        bw.close();
    }
}
