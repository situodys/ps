package ps.프로그래머스.lv3;

import java.util.*;

public class 합승_택시_요금 {
    import java.util.*;

    class Solution {
        public static List<int[]>[] edges;
        public static int[] dst;
        public static int[] cands;
        public static int answer = Integer.MAX_VALUE;
        public static final int MAX_VAL = 20000001;

        public int solution(int n, int s, int a, int b, int[][] fares) {
            edges = new List[n+1];
            dst = new int[n+1];
            cands =new int[n+1];


            for(int i=0; i<=n;i++){
                edges[i] = new ArrayList<>();
            }

            for(int[] fare : fares){
                int from= fare[0];
                int to =fare[1];
                int w = fare[2];

                edges[from].add(new int[]{w,to});
                edges[to].add(new int[]{w,from});
            }

            dij(s,n);

            for(int i=1; i<=n;i++){
                if(dst[i]==MAX_VAL) continue;
                cands[i]+=dst[i];
            }

            for(int i=1; i<=n;i++){
                if(cands[i]==0) continue;
                dij(i,n);
                cands[i]+=dst[a]+dst[b];
            }


            //si, ia, ib

            for(int i=1; i<=n;i++){
                System.out.println(i+"."+cands[i]);
            }
            return answer;
        }

        public void dij(int start, int t){
            PriorityQueue<int[]> pq = new PriorityQueue<>((int[] x,int[] y)->{
                return x[0]-y[0];
            });
            dst = new int[t+1];

            for(int j=1; j<=t;j++){
                if(start==j)continue;
                dst[j]= MAX_VAL;
            }

            pq.offer(new int[]{0,start});

            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int w = cur[0];
                int v = cur[1];

                if(dst[v] != w) continue;
                for(int[] edge: edges[v]){
                    int nxtW = edge[0];
                    int nxtV= edge[1];
                    if(dst[nxtV] <= dst[v]+nxtW) continue;
                    dst[nxtV] = dst[v]+nxtW;
                    pq.offer(new int[]{dst[nxtV],nxtV});
                }
            }
        }
    }
}
