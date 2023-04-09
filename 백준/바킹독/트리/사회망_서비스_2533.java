package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사회망_서비스_2533 {


    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static List<Integer>[] edges;
    public static List<Node> nodes;
    public static boolean[] visited;

    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;
    private static int idx=0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        edges = new List[n + 1];
        nodes = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <=n; i++) {
            edges[i]= new ArrayList<>();
            nodes.add(new Node(i, false));
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
        }

        dfs(1);

        System.out.println(answer);
    }

    private static boolean dfs(int start) {
        visited[start]=true;
        boolean isCurrentAdaptor=false;
        for (Integer nxt : edges[start]) {
            if(visited[nxt]) continue;
            if (!dfs(nxt)) {
                if(nodes.get(start).isEarlyAdaptor) continue;
                answer++;
                nodes.get(start).isEarlyAdaptor=true;
                isCurrentAdaptor=true;
            }
        }
        return isCurrentAdaptor;
    }

    private static class Node {
        int number;
        boolean isEarlyAdaptor;

        public Node(int number, boolean isEarlyAdaptor) {
            this.number = number;
            this.isEarlyAdaptor = isEarlyAdaptor;
        }
    }
}
