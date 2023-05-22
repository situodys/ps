package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_9465 {
    public static int n, m, a, b, c;
    public static int dy[] = {0, 0, -1, 1, 0, 0};
    public static int dx[] = {1, -1, 0, 0, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[][] dp;
    public static int[][] stickers;
    public static int answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while(t-->0){
            n = Integer.parseInt(br.readLine());

            stickers = new int[2][100001];
            dp = new int[2][100001];

            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    stickers[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0]=stickers[0][0];
            dp[1][0]=stickers[1][0];
            dp[0][1] = Math.max(dp[0][0], stickers[0][1] + dp[1][0]);
            dp[1][1] = Math.max(dp[1][0], stickers[1][1] + dp[0][0]);

            for(int i=2;i<n;i++){
                dp[0][i] = Math.max(dp[1][i - 1],dp[1][i - 2])+ stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1],dp[0][i-2]) + stickers[1][i];
            }

            System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));
        }
    }

}
