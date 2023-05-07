package ps.백준.바킹독.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753 {

    public static int v,e,start;
    public static int dy[] = {0, 0, -1, 1,0,0};
    public static int dx[] = {1, -1, 0, 0,0,0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[] dst;
    public static boolean[] visited;
    public static List<int[]>[] edges;
    public static int answer = 0;
    public static int MAX_VAlUE = 300001;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        dst = new int[v + 1];
        visited = new boolean[v + 1];
        visited[start]=true;
        edges = new List[v + 1];
        for(int i=0; i<=v;i++){
            edges[i] = new ArrayList<>();
        }


        for(int i=0; i<=v;i++){
            if(i==start) continue;
            dst[i]=MAX_VAlUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[from].add(new int[]{to, cost});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((int[] a, int[] b)->a[0]-b[0]);
        q.offer(new int[]{0, start});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curDist = cur[0];
            int vert = cur[1];
            if(dst[vert] != curDist) continue;
            for (int[] edge : edges[vert]) {
                if(dst[edge[0]] <= dst[vert]+edge[1])continue;
                dst[edge[0]] = dst[vert] + edge[1];
                q.offer(new int[]{dst[edge[0]], edge[0]});
            }
        }

        for(int i=1; i<=v; i++){
            if (dst[i] == MAX_VAlUE) {
                System.out.println("INF");
            } else {
                System.out.println(dst[i]);
            }
        }
    }
}
