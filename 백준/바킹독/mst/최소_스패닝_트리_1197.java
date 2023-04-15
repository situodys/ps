package ps.백준.바킹독.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최소_스패닝_트리_1197 {

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
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i=1; i<=n;i++){
            parents[i]= i;
        }

        List<Edge> edges = new ArrayList<>();

        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(v1, v2, w));
        }

        edges.sort((e1, e2) -> e1.w - e2.w);

        int e=0;
        for (int i = 0; i < m; i++) {
            Edge cur = edges.get(i);
            if (isUnion(cur.v1, cur.v2)) {
                continue;
            }
            merge(cur.v1, cur.v2);

            answer += cur.w;
            e++;
            if(e==n-1) break;
        }
        System.out.println(answer);
    }

    private static boolean isUnion(int a, int b) {
        return find(a) == find(b);
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static void merge(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA < parentB) {
            parents[parentB] =parentA;
        }
        else parents[parentA] =parentB;
    }

    private static class Edge{
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
