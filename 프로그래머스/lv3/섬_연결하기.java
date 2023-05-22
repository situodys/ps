package ps.프로그래머스.lv3;

import java.util.*;

public class 섬_연결하기 {

    public static int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        parents = new int[n+1];
        for(int i=1; i<=n;i++){
            parents[i]= i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a)->a[2]));

        for(int[] cost : costs){
            pq.offer(cost);
        }

        int edgeCnt=0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(isUnion(cur[0],cur[1])) continue;
            merge(cur[0],cur[1]);
            edgeCnt++;
            answer+=cur[2];
            if(edgeCnt==n-1) break;
        }

        return answer;
    }

    private boolean isUnion(int a, int b){
        return find(a)==find(b);
    }

    private int find(int x){
        if(parents[x]==x)
            return x;
        return parents[x]=find(parents[x]);
    }

    private void merge(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA<parentB){
            parents[parentB]=parentA;
        }
        else parents[parentA]=parentB;
    }
}
