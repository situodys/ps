package ps.프로그래머스.lv3;

import java.util.*;

public class 가장_먼_노드 {
    public static List<Integer>[] edges;
    public static int[] visited;

    public int solution(int n, int[][] edge) {
        int answer=0;
        edges = new List[n+1];
        for(int i=0; i<=n;i++){
            edges[i] = new ArrayList<>();
        }
        visited = new int[n+1];

        for(int[] e : edge){
            int from = e[0];
            int to = e[1];
            edges[from].add(to);
            edges[to].add(from);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1]=1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int nxt : edges[cur]){
                if(visited[nxt] != 0) continue;
                visited[nxt] = visited[cur]+1;
                if(visited[nxt] > answer){
                    answer = visited[nxt];
                }
                q.offer(nxt);
            }
        }
        int cnt=0;
        for(int i=1; i<=n;i++){
            if(visited[i]==answer){
                cnt++;
            }
        }
        return cnt;
    }
}
