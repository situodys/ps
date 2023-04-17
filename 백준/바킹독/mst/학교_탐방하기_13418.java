package ps.백준.바킹독.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 학교_탐방하기_13418 {
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
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, w));
        }
        edges.sort((e1,e2)->e2.w-e1.w);

        int connectedEdgeCnt=0;

        for(int i=0;i<edges.size();i++){
            Edge cur = edges.get(i);
            if (isUnion(cur.a, cur.b)) {
                continue;
            }
            merge(cur.a, cur.b);
            connectedEdgeCnt++;
            if(cur.w ==0 ) answer++;
            if(connectedEdgeCnt==n)
                break;
        }
        long minVal = answer*answer;

        for (int i = 0; i <= n; i++) {
            parents[i]=i;
        }
        connectedEdgeCnt=0;
        answer=0;
        edges.sort(Comparator.comparing(e -> e.w));


        for(int i=0;i<edges.size();i++){
            Edge cur = edges.get(i);
            if (isUnion(cur.a, cur.b)) {
                continue;
            }
            merge(cur.a, cur.b);
            connectedEdgeCnt++;
            if(cur.w ==0 ) answer++;
            if(connectedEdgeCnt==n)
                break;
        }
        long maxVal = answer*answer;

        System.out.println(maxVal-minVal);

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
        int a; int b; int w;

        public Edge(int a, int b, int w) {
            this.a =a;
            this.b=b;
            this.w=w;
        }
    }
}
