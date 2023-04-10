package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의_지름_1967 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static List<Integer>[] edges;
    public static List<Integer>[] scores;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;
    private static int idx=0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        edges = new List[n + 1];
        scores = new List[n + 1];

        for (int i = 0; i <=n; i++) {
            edges[i] = new ArrayList<>();
            scores[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
            scores[from].add(w);
            scores[to].add(w);
        }

        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(idx, 0);

        System.out.println(answer);
    }

    private static void dfs(int start, int dist) {
        if (answer < dist) {
            answer = dist;
            idx = start;
        }
        visited[start]=true;

        List<Integer> cur = edges[start];
        for(int i=0; i< cur.size();i++){
            if(visited[cur.get(i)])continue;
            dfs(cur.get(i),dist+scores[start].get(i));
        }
    }
}
