package ps.백준.바킹독.플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백양로_브레이크_11562 {

    /*
    바꿔줘야 하는 다리를 1로 표현하면 이에 대해 최단거리를 구하는게 곧
    s->e까지 최소로 바꿔줘야하는 다리의 수가 된다..
     */

    public static int n, m, r;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[][] dst;
    public static int[][] visited;
    public static int order = 1;
    public static StringBuilder sb = new StringBuilder();
    private static final int MAX_FEE = 300;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dst = new int[n + 1][n + 1];
        visited = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                dst[i][j] = MAX_FEE;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dst[u][v] = 0;
            if (b == 1) {
                dst[v][u] = 0;
            }
            else{
                dst[v][u]=1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    if (dst[j][l] > dst[j][i] + dst[i][l]) {
                        dst[j][l] = dst[j][i] + dst[i][l];
                    }
                }
            }
        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(dst[i][j] + " ");
//            }
//            System.out.println();
//        }

//        System.out.println();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }

        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k;i++){
            st = new StringTokenizer(br.readLine());
            int s= Integer.parseInt(st.nextToken());
            int e= Integer.parseInt(st.nextToken());
            System.out.println(dst[s][e]);
        }
    }
}
