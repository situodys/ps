package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드_구매하기_11052 {

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

        dp = new int[1001];
        values = new int[1001];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n;i++){
            values[i] = Integer.parseInt(st.nextToken());
        }

        dp[1]=values[1];

        for(int i=2; i<=n;i++){
            for(int j=0; j<i;j++){
                dp[i] = Math.max(dp[i], dp[j] + values[i - j]);
            }
        }

        System.out.println(dp[n]);
    }
}
