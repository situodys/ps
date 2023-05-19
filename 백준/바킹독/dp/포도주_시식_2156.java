package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 포도주_시식_2156 {
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

        dp = new int[10001];
        values = new int[10001];

        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = values[0];
        dp[1] = values[0] + values[1];
        dp[2] = Math.max(dp[1],
                Math.max(values[1] + values[2], values[0] + values[2]));

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(
                    dp[i - 2], dp[i - 3] + values[i - 1]
            ) + values[i];
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        System.out.println(dp[n - 1]);
    }
}
