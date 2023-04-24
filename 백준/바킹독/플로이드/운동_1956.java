package ps.백준.바킹독.플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 운동_1956 {


    public static int n, m, r;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[][] dst;
    public static List<Integer>[] edges;
    public static int[] visited;
    public static int[] finished;
    public static int order=1;
    public static StringBuilder sb = new StringBuilder();
    private static int answer = Integer.MAX_VALUE;
    private static final int MAX_FEE = 200000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        dst = new int[n + 1][n + 1];
        edges = new List[n + 1];
        for(int i=0;i <=n;i++){
            edges[i] = new ArrayList<>();
        }
        visited = new int[n + 1];
        finished = new int[n + 1];

        for(int i=1; i<=n;i++){
            for(int j=1; j<=n;j++){
                if(i==j) continue;
                dst[i][j] = MAX_FEE;
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dst[from][to] = w;
        }

        for(int i=1; i<=n;i++){
            for(int j=1;j<=n;j++){
                for (int k = 1; k <= n; k++) {
                    if (dst[j][k] > dst[j][i] + dst[i][k]) {
                        dst[j][k] = dst[j][i] + dst[i][k];
                    }
                }
            }
        }

        for(int i=1; i<=n;i++){
            for(int j=1; j<=n;j++){
                if(i==j) continue;
                if (dst[i][j] != MAX_FEE && dst[j][i] != MAX_FEE) {
                    answer = Math.min(answer, dst[i][j] + dst[j][i]);
                }
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
