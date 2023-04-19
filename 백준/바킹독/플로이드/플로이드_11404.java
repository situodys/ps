package ps.백준.바킹독.플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드_11404 {
    public static int n, m, k;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[][] dst;
    public static int[][] weights;
    public static StringBuilder sb = new StringBuilder();
    private static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dst = new int[n + 1][n + 1];
        weights = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=n ; j++) {
                if(i==j) continue;
                dst[i][j] = 10000000;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dst[from][to]=Math.min(dst[from][to],w);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (dst[j][k] > dst[j][i] + dst[i][k]) {
                        dst[j][k] = dst[j][i] + dst[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(dst[i][j]==10000000)
                    dst[i][j]=0;
                System.out.print(dst[i][j]+" ");
            }
            System.out.println();
        }
    }
}
