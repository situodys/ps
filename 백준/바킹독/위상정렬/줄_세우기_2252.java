package ps.백준.바킹독.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 줄_세우기_2252 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static List<Integer>[] edges;
    public static int[] ingressCnt;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;
    private static int idx = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new List[n + 1];
        ingressCnt = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from].add(to);
            ingressCnt[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (ingressCnt[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');
            for (Integer nxt : edges[cur]) {
                ingressCnt[nxt]--;
                if (ingressCnt[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }
        System.out.println(sb);
    }
}
