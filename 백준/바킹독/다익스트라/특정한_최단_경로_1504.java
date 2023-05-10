package ps.백준.바킹독.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한_최단_경로_1504 {

    public static int n,m,start, v1,v2;
    public static int dy[] = {0, 0, -1, 1,0,0};
    public static int dx[] = {1, -1, 0, 0,0,0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[][] dist;
    public static List<int[]>[] edges;
    public static int answer = 0;
    public static int MAX_VAlUE = 200000000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[3][n + 1];
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
            edges[to].add(new int[]{w, from});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        if (v1 == v2) {
            System.out.println(0);
            return;
        }

        //1 ->v1 -> v2-> n , 1 1 2 4
        //1-> v2->v1->n  , 1 2 1 4

        int starts[] = new int[]{1, v1, v2};
        int answers[] = new int[2];
        for(int i=0; i<starts.length;i++){
            for(int j=0; j<=n;j++){
                if(j==starts[i]) continue;
                dist[i][j] = MAX_VAlUE;
            }
            findDistByNo(starts[i],dist[i]);
        }

//        0:1 1:v1 2:v2
        answers[0]=dist[0][v1]+dist[1][v2]+dist[2][n];
        answers[1]=dist[0][v2]+dist[1][n]+dist[2][v1];

        answer = Math.min(answers[0], answers[1]);
        if(answer >=MAX_VAlUE) answer=-1;
        System.out.println(answer);
    }

    private static void findDistByNo(int startNode,int[] curDist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));

        pq.offer(new int[]{0, startNode});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cost = cur[0];
            int v = cur[1];
            if(curDist[v] != cost) continue;
            for (int[] nxt : edges[v]) {
                int val=nxt[0];
                int nxtV=nxt[1];
                if(curDist[nxtV] <= curDist[v]+val) continue;
                curDist[nxtV] = curDist[v]+val;
                pq.offer(new int[]{curDist[nxtV],nxtV});
            }
        }
    }
}
