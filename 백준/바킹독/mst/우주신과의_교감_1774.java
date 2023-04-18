package ps.백준.바킹독.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 우주신과의_교감_1774 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[] parents;
    public static List<Edge> edges;
    public static StringBuilder sb = new StringBuilder();
    private static double answer = 0;
    private static int idx = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i]=i;
        }
        edges = new ArrayList<>();
        List<Integer>[] vertexes = new List[n];
        for (int i = 0; i < n; i++) {
            vertexes[i] = new ArrayList<>();
        }
        int connectedEdgeCnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            vertexes[i].add(x);
            vertexes[i].add(y);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (isUnion(a, b)) {
                continue;
            }
            merge(a,b);
            connectedEdgeCnt++;
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(isUnion(i+1,j+1)) continue;
                List<Integer> pointA = vertexes[i];
                List<Integer> pointB = vertexes[j];
                double subX = (double)pointA.get(0) - (double)pointB.get(0);
                double subY = (double)pointA.get(1) - (double)pointB.get(1);
                double len = Math.sqrt(subX * subX + subY * subY);
                edges.add(new Edge(i+1,j+1,len));
            }
        }
        edges.sort(Comparator.comparing(e -> e.w));

        for(int i=0; i<edges.size();i++){
            Edge cur = edges.get(i);
            if(isUnion(cur.a,cur.b)) continue;
            merge(cur.a,cur.b);
            answer += cur.w;
            connectedEdgeCnt++;
            if(connectedEdgeCnt==n-1)break;
        }

        System.out.printf("%.2f",answer);

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

    private static void merge(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if (parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
    }

    private static class Edge {
        int a; int b; double w;

        public Edge(int a, int b, double w) {
            this.a =a;
            this.b=b;
            this.w=w;
        }
    }
}
