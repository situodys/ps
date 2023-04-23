package ps.백준.바킹독.플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 우주_탐사선_17182 {

    public static int n, m, r;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[][] dst;
    public static boolean[] visited;
    public static List<Integer> orders = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    private static int answer = Integer.MAX_VALUE;
    private static final int MAX_DIST = 200000001;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dst = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
//                if(val==0) val= MAX_DIST;
                dst[i][j] = val;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dst[j][k] > dst[j][i] + dst[i][k]) {
                        dst[j][k] = dst[j][i] + dst[i][k];
                    }
                }
            }
        }
        visited[m]=true;
        orders.add(m);
        tracking(1);
        System.out.println(answer);
    }

    private static void tracking(int cnt) {
        if (cnt == n) {
            answer = Math.min(answer, calculate());
            return;
        }

        for(int i=0; i<n;i++){
            if(visited[i]) continue;
            visited[i]=true;
            orders.add(i);
            tracking(cnt+1);
            visited[i]=false;
            orders.remove(orders.size()-1);
        }
    }

    private static int calculate() {
        int sum=0;
        for (int i = 0; i < n-1; i++) {
            sum += dst[orders.get(i)][orders.get(i+1)];
        }
        return sum;
    }
}
