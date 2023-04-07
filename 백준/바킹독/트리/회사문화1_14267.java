package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 회사문화1_14267 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int parents[];
    public static long scores[];
    public static boolean visited[];
    public static List<Integer>[] edges;

    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        edges = new List[n + 1];
        scores = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            parents[i] = cur;
            if(cur==-1) continue;
            edges[cur].add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            scores[start]+=w;
        }

        bfs(1);

        for (int i = 1; i <= n; i++) {
            sb.append(scores[i]).append(' ');
        }
        System.out.println(sb);

    }

    private static void bfs(int start) {
        visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer nxt : edges[cur]) {
                if (visited[nxt]) {
                    continue;
                }
                q.offer(nxt);
                visited[nxt]=true;
                scores[nxt]+=scores[cur];
            }
        }
    }
}
