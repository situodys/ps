package ps.백준.바킹독.플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서강그라운드_14938 {
    public static int n, m, r;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[][] dst;
    public static int visited[][];
    public static StringBuilder sb = new StringBuilder();
    private static int answer = 0;
    private static final int MAX_FEE = 10000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[] item = new int[n + 1];
        dst = new int[n + 1][n + 1];

        st= new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==j)continue;
                dst[i][j] = MAX_FEE;
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dst[from][to] = Math.min(dst[from][to], w);
            dst[to][from] = Math.min(dst[to][from], w);
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n ; j++) {
                for (int k = 1; k <=n; k++) {
                    if (dst[j][k] > dst[j][i] + dst[i][k]) {
                        dst[j][k] = dst[j][i]+ dst[i][k];
                    }
                }
            }
        }

        for(int i=1; i<=n;i++){
            int items=0;
            for(int j=1; j<=n;j++){
                if(dst[i][j] >m )continue;
                items += item[j];
            }
            answer =Math.max(answer,items);
        }
        System.out.println(answer);
    }
}
