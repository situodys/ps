package ps.프로그래머스.lv2;

import java.util.*;

public class 전력망을_둘로_나누기 {

    public static List<Integer>[] edges;
    public static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer =300;
        edges = new List[n+1];

        for(int i=0; i<=n;i++){
            edges[i] = new ArrayList<>();
        }

        for(int[] wire : wires){
            int from = wire[0];
            int to = wire[1];
            edges[from].add(to);
            edges[to].add(from);
        }

        for(int i=0 ;i<wires.length;i++){
            int[] deletedEdge = wires[i];
            int from = deletedEdge[0];
            int to = deletedEdge[1];
            edges[from].remove(Integer.valueOf(to));
            edges[to].remove(Integer.valueOf(from));

            int nodeCount = calculate(n);

            answer = Math.min(Math.abs(nodeCount*2-n),answer);
            edges[from].add(to);
            edges[to].add(from);
        }

        return answer;
    }

    private int calculate(int tot){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[tot+1];

        q.offer(1);
        visited[1]=true;
        int cnt=1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int nxt : edges[cur]){
                if(visited[nxt]) continue;
                q.offer(nxt);
                visited[nxt]=true;
                cnt++;
            }
        }
        return cnt;
    }
}
