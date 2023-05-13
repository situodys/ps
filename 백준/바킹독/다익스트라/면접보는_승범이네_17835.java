package ps.백준.바킹독.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 면접보는_승범이네_17835 {

    public static int n, m, k;
    public static int dy[] = {0, 0, -1, 1, 0, 0};
    public static int dx[] = {1, -1, 0, 0, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static long[] dist;
    public static List<long[]>[] edges;
    public static int[][] board;
    public static boolean[][] visited;
    public static int answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];

        for(int i=0; i<=n;i++){
            dist[i] = Long.MAX_VALUE;
        }

        edges = new List[n + 1];

        for(int i=0; i<=n;i++){
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[to].add(new long[]{w, from});
        }

        st = new StringTokenizer(br.readLine());
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong((long[] a) -> a[0]));

        int[] starts = new int[k];
        for(int i=0; i<k;i++){
            starts[i] = Integer.parseInt(st.nextToken());
            dist[starts[i]]=0;
            pq.offer(new long[]{0, starts[i]});
        }

        while (!pq.isEmpty()) {
            long cur[] = pq.poll();
            long w= cur[0];
            int v = (int)cur[1];
            if(dist[v] != w) continue;
            for (long[] nxt : edges[v]) {
                long nxtW=nxt[0];
                int nxtV = (int) nxt[1];
                if(dist[nxtV] <= dist[v]+nxtW) continue;
                dist[nxtV] = dist[v]+nxtW;
                pq.offer(new long[]{dist[nxtV], nxt[1]});
            }
        }

        long maxVal = 0;
        int idx=0;
        for(int i=1; i<=n;i++){
            if(dist[i]==Long.MAX_VALUE || dist[i]==0) continue;
            if(maxVal>= dist[i]) continue;
            maxVal=dist[i];
            idx=i;
        }
        System.out.println(idx);
        System.out.println(maxVal);
    }
}
