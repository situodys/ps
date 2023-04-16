package ps.백준.바킹독.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 행성_연결_16398 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[] parents;
    public static List<Integer>[] edges;
    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;
    private static int idx = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (j <= i) {
                    st.nextToken();
                    continue;
                }
                int w = Integer.parseInt(st.nextToken());
                edges.add(new Edge(i, j, w));
            }
        }

        edges.sort(Comparator.comparingInt(e -> e.w));

        int connectedEdgeCnt = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge cur = edges.get(i);
            if (isUnion(cur.v1, cur.v2)) {
                continue;
            }
            merge(cur.v1, cur.v2);
            answer += cur.w;
            connectedEdgeCnt++;
            if (connectedEdgeCnt == n - 1) {
                break;
            }
        }
        System.out.println(answer);
    }

    private static void merge(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA < parentB) {
            parents[parentB] = parentA;
        }
        else parents[parentA] = parentB;
    }

    private static boolean isUnion(int a, int b) {
        return findParent(a) == findParent(b);
    }

    private static int findParent(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = findParent(parents[x]);
    }

    private static class Edge {
        int v1;
        int v2;
        int w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }
}
