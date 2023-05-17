package ps.프로그래머스.lv2;

import java.util.*;

public class 숫자_변환하기 {
    public static int visited[];
    public int solution(int x, int y, int n) {
        int answer = 0;

        visited = new int[y+1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x]=1;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur==y) break;
            int[] nxts = new int[]{cur+n,cur*2,cur*3};
            for(int nxt : nxts){
                if(nxt >y) continue;
                if(visited[nxt] != 0) continue;
                q.offer(nxt);
                visited[nxt]= visited[cur]+1;
            }
        }
        if(visited[y]==0) answer=-1;
        else answer= visited[y]-1;

        return answer;
    }
}
