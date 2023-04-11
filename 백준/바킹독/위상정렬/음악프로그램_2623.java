package ps.백준.바킹독.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 음악프로그램_2623 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static List<Integer>[] edges;
    public static int[] indegree;
    public static Set<Integer> checked;
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
        indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int orders = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            for (int j = 1; j < orders; j++) {
                int cur = Integer.parseInt(st.nextToken());
                edges[pre].add(cur);
                indegree[cur]++;
                pre = cur;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> ls = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            ls.add(cur);
            for (Integer nxt : edges[cur]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }
        if (ls.size() != n) {
            System.out.println(0);
            return;
        }
        for (Integer l : ls) {
            sb.append(l).append('\n');
        }
        System.out.print(sb);
    }
}
