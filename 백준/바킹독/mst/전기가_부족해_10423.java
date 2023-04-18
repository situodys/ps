package ps.백준.바킹독.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전기가_부족해_10423 {

    public static int n, m, k;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[] parents;
    public static List<Edge>[] edges;
    public static StringBuilder sb = new StringBuilder();
    private static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        List<Integer> cities = new ArrayList<>();
        boolean[] isLinked = new boolean[n + 1];
        edges = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            int elec = Integer.parseInt(st.nextToken());
            cities.add(elec);
            isLinked[elec] = true;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, w));
            edges[b].add(new Edge(a, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.w));

        for (int i = 0; i < cities.size(); i++) {
            Integer no = cities.get(i);
            for (Edge edge : edges[no]) {
                pq.offer(edge);
            }
        }

        while (cities.size() != n) {
            Edge cur = pq.poll();
            if (isLinked[cur.b]) {
                continue;
            }
            answer += cur.w;
            isLinked[cur.b] = true;
            cities.add(cur.b);
            for (Edge edge : edges[cur.b]) {
                pq.offer(edge);
            }
        }
        System.out.println(answer);
    }

    private static class Edge {
        int b;
        int w;

        public Edge(int b, int w) {
            this.b = b;
            this.w = w;
        }
    }
}
