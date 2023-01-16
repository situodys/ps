package ps.프로그래머스.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public static int board[][];
    public static int visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new int[n];

        for(int i=0;i<n;i++){
            if(visited[i] != 0)continue;
            answer++;
            visited[i]=answer;
            Queue<Integer> q =  new LinkedList<>();
            q.offer(i);
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int dir=0;dir<computers[cur].length;dir++){
                    if(computers[cur][dir] ==0 ) continue;
                    if(visited[dir] != 0) continue;
                    visited[dir]=answer;
                    q.offer(dir);
                }
            }
        }
        return answer;
    }
}
