package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _01타일_1904 {
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

        dp = new int[1000001];

        dp[1]=1;
        dp[2]=2;

        for(int i=3; i<=n;i++){
            dp[i] = (dp[i - 1] + dp[i - 2])%15746;
        }

        System.out.println(dp[n]);
    }
}
