package ps.백준.바킹독.플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 플로이드2_11780 {
    public static int n, m, k;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[][] dst;
    public static int visited[][];
    public static StringBuilder sb = new StringBuilder();
    private static int answer = 0;
    private static final int MAX_FEE = 10000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dst = new int[n + 1][n + 1];
        visited = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==j) continue;
                dst[i][j] = MAX_FEE;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (dst[from][to] > cost) {
                dst[from][to] = cost;
            }
            visited[from][to]=to;
        }

        for (int by = 1; by <= n; by++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (dst[s][e] > dst[s][by] + dst[by][e]) {
                        dst[s][e] = dst[s][by] + dst[by][e];
                        visited[s][e]=visited[s][by];
                    }
                }
            }
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= n; j++) {
                if(dst[i][j]==MAX_FEE) dst[i][j]=0;
                System.out.print(dst[i][j]+" ");
            }
            System.out.println();
        }

        for (int start = 1; start <= n; start++) {
            for (int end = 1; end <= n; end++) {
                sb = new StringBuilder();
                List<Integer> l = new ArrayList<>();
                int cur=start;
                l.add(start);
                while (visited[cur][end] != 0) {
                    l.add(visited[cur][end]);
                    cur = visited[cur][end];
                }
                if (l.size() == 1) {
                    System.out.println(0);
                    continue;
                }
                sb.append(l.size()).append(" ");
                for(int i=0; i<l.size();i++){
                    sb.append(l.get(i)).append(" ");
                }
                System.out.println(sb);
            }
        }
    }
}
