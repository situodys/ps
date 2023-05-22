package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오르막수_11057 {

    public static int n, m, a, b, c;
    public static int dy[] = {0, 0, -1, 1, 0, 0};
    public static int dx[] = {1, -1, 0, 0, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[][] dp;
    public static int[] values;
    public static int answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        dp = new int[1001][10];

        for(int i=0; i<=9;i++){
            dp[1][i]=1;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0]=1;
        }

        dp[0][0]=0;

        for(int i=2; i<=n;i++){
            for(int j=1; j<=9;j++){
                dp[i][j] = (dp[i - 1][j]% 10007 + dp[i][j - 1]% 10007) ;
            }
        }

        for(int i=0; i<=9;i++){
            answer = answer + dp[n][i];
        }
        System.out.println(answer%10007);
    }
}
