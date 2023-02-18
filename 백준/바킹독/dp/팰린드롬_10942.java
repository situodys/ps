package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 팰린드롬_10942 {
    public static int t, n, target, s, e;
    public static int[] numbers;
    public static boolean dp[][];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        dp = new boolean[n][n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ;i<n-1;i++){
            dp[i][i]= true;
            if(numbers[i]==numbers[i+1])
                dp[i][i+1]=true;
        }
        dp[n-1][n-1]=true;

        for (int len = 2; len < n; len++) {
            for (int j = 0; j < n-len; j++) {
                dp[j][j+len]= numbers[len+j]==numbers[j] && dp[j+1][j+len-1];
            }
        }

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            bw.write((dp[s - 1][e - 1]? 1:0) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
