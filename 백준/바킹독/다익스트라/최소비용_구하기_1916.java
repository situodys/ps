package ps.백준.바킹독.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용_구하기_1916 {

    public static int n,m,start, v1,v2;
    public static int dy[] = {0, 0, -1, 1,0,0};
    public static int dx[] = {1, -1, 0, 0,0,0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[] dist;
    public static List<int[]>[] edges;
    public static int answer = 0;
    public static int MAX_VAlUE = 200000000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        edges = new List[n + 1];

        for(int i=0; i<=n;i++){
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[from].add(new int[]{w, to});
        }

        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n;i++){
            if(i==v1) continue;
            dist[i] = MAX_VAlUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a)->a[0]));
        pq.offer(new int[]{0,v1});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int w= cur[0];
            int v = cur[1];
            if(w!=dist[v]) continue;
            for (int[] nxt : edges[v]) {
                int nxtW=nxt[0];
                int nxtV = nxt[1];
                if(dist[nxtV] <= dist[v]+nxtW ) continue;
                dist[nxtV] = dist[v] + nxtW;
                pq.offer(new int[]{dist[nxtV], nxtV});
            }
        }

        System.out.println(dist[v2]);
    }
}
