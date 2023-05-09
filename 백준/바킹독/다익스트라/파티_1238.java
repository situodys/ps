package ps.백준.바킹독.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238 {
    public static int n,m,start,destination;
    public static int dy[] = {0, 0, -1, 1,0,0};
    public static int dx[] = {1, -1, 0, 0,0,0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[] dist;
    public static int[] distSum;
    public static int[] history;
    public static List<int[]>[] edges;
    public static int answer = 0;
    public static int MAX_VAlUE = 200000000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        distSum = new int[n + 1];
        edges = new List[n+1];

        for(int i=0; i<=n;i++){
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[from].add(new int[]{w, to});
        }

        for(int i=1; i<=n;i++){
            findDistByNo(i);
            if(i==start){
                for (int j = 1; j <= n; j++) {
                    distSum[j] += dist[j];
                }
            }
            else{
                distSum[i] += dist[start];
            }
        }

        for(int i=1; i<=n;i++){
            answer = Math.max(answer, distSum[i]);
        }
        System.out.println(answer);
    }

    private static void findDistByNo(int startNode) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));
        dist = new int[n + 1];
        for(int i=0; i<=n;i++){
            if(i==startNode) continue;
            dist[i] = MAX_VAlUE;
        }

        pq.offer(new int[]{0, startNode});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cost = cur[0];
            int v = cur[1];
            if(dist[v] != cost) continue;
            for (int[] nxt : edges[v]) {
                int val=nxt[0];
                int nxtV=nxt[1];
                if(dist[nxtV] <= dist[v]+val) continue;
                dist[nxtV] = dist[v]+val;
                pq.offer(new int[]{dist[nxtV],nxtV});
            }
        }
    }
}
