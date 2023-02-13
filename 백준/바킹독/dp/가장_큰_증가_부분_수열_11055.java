package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가장_큰_증가_부분_수열_11055 {
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
            dp[i]=numbers[i];
        }

        for(int i=0 ; i<n;i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + numbers[i]);
                }
            }
        }

        for(int i=0 ; i<n;i++){
            answer = Math.max(answer,dp[i]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
