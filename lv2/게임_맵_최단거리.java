package programmers.lv2;

import java.util.*;

public class 게임_맵_최단거리 {

    public static int[] dy = {0,0,-1,1};
    public static int[] dx = {1,-1,0,0};
    public static int[][] visited;

    public int solution(int[][] maps) {
        int answer = 0;
        int len = maps.length;
        int lenx = maps[0].length;
        visited = new int[len][lenx];

        bfs(maps);

        if(visited[len-1][lenx-1] ==0 )
            return -1;

        return visited[len-1][lenx-1];
    }

    public void bfs(int[][] maps){
        Queue<Integer[]> q = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;

        visited[0][0]=1;
        q.offer(new Integer[]{0,0});

        while(!q.isEmpty()){
            Integer[] cur = q.poll();
            for(int dir = 0 ; dir< 4; dir++){
                int ny = cur[0] + dy[dir];
                int nx = cur[1] + dx[dir];

                if(ny<0 || nx <0 || ny>=n || nx>=m) continue;
                if(visited[ny][nx] != 0 || maps[ny][nx] ==0 ) continue;
                visited[ny][nx] = visited[cur[0]][cur[1]]+1;
                q.offer(new Integer[]{ny,nx});
            }
        }
    }
}
