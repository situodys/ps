package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 연속합_1912 {

    public static int n;
    public static int numbers[];
    public static int dp[];
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0 ; i<n;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i]= numbers[i];
        }

        dp[0]=numbers[0];

        for(int i=1 ; i<n;i++) {
            dp[i] = Math.max(numbers[i], dp[i-1]+numbers[i]);
        }

        for(int i=0 ; i<n;i++){
            answer = Math.max(answer,dp[i]);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
