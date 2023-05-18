package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 설탕배달_2839 {
    public static int n, m, a, b, c;
    public static int dy[] = {0, 0, -1, 1, 0, 0};
    public static int dx[] = {1, -1, 0, 0, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[] dp;
    public static int[] values;
    public static int answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[5001];
        Arrays.fill(dp, 10000);
        dp[3]=1;
        if (n == 4) {
            System.out.println(-1);
            return;
        }
        dp[5]=1;
        for(int i=6; i<=n;i++){
            dp[i] = Math.min(dp[i-3],dp[i-5])+1;
        }
        if(dp[n]>=10000) dp[n]=-1;
        System.out.println(dp[n]);
    }
}
