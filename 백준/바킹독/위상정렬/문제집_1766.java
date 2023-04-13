package ps.백준.바킹독.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집_1766 {
    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static Map<String, Integer> mp;
    public static Map<Integer, String> mpByIdx;
    public static int[] indegree;
    public static List<Integer>[] edges;
    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;
    private static int idx = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];
        edges = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from].add(to);
            indegree[to]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur+" ");
            for (Integer nxt : edges[cur]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }
    }
}
