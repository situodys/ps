package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 노드사이의_거리_1240 {
    public static int n, r, q;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static List<Integer>[] edges;
    public static int[] parents;
    public static int[][] dist;
    public static int[] size;

    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];
        edges = new List[n + 1];

        for (int i = 0; i <=n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            edges[from].add(to);
            edges[to].add(from);
            dist[from][to]=val;
            dist[to][from]=val;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int visited[] = new int[n + 1];
            sb.append(getDist(start, end, visited)+1).append('\n');
        }

        System.out.println(sb);

    }

    private static int getDist(int start, int end, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=-1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer nxt : edges[cur]) {
                if (nxt == end) {
                    return visited[cur] + dist[cur][end];
                }
                if(visited[nxt] != 0) continue;
                q.offer(nxt);
                visited[nxt] = visited[cur] + dist[cur][nxt];
            }
        }
        return 0;
    }
}
