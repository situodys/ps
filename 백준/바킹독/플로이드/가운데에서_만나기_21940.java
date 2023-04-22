package ps.백준.바킹독.플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가운데에서_만나기_21940 {

    public static int n, m, r;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[][] dst;
    public static int visited[][];
    public static StringBuilder sb = new StringBuilder();
    private static int answer = Integer.MAX_VALUE;
    private static final int MAX_DIST = 200000001;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dst = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                dst[i][j] = MAX_DIST;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dst[from][to] = Math.min(dst[from][to], w);
        }

        r = Integer.parseInt(br.readLine());
        List<Integer> friends = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < r; i++) {
            friends.add(Integer.parseInt(st.nextToken()));
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

        int[] answers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (Integer friend : friends) {
                sum = Math.max(sum, dst[friend][i] + dst[i][friend]);
            }
            answers[i]=sum;
            answer = Math.min(sum, answer);
        }
        for (int i = 1; i <= n; i++) {
            if (answers[i] == answer) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }
}
