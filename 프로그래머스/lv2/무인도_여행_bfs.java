package ps.프로그래머스.lv2;

import java.util.*;

public class 무인도_여행_bfs {

    public static int[][] board;
    public static boolean[][] visited;
    public static int n;
    public static int m;
    public static int[] dy = {0,0,-1,1};
    public static int[] dx = {1,-1,0,0};
    public List<Integer> answers = new ArrayList<>();
    public int[] solution(String[] maps) {
        n =maps.length;
        m = maps[0].length();
        System.out.println(n +" "+m);
        board= new int[n][m];
        visited= new boolean[n][m];

        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(maps[i].charAt(j)=='X') continue;
                board[i][j] = maps[i].charAt(j)-'0';
            }
        }

        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(visited[i][j] || board[i][j]==0) continue;
                int days = countDays(i,j);
                answers.add(days);
            }
        }
        answers.sort(Comparator.naturalOrder());
        if(answers.isEmpty()){
            return new int[]{-1};
        }
        int[] answer = new int[answers.size()];

        for(int i=0; i<answers.size();i++){
            answer[i]= answers.get(i);
        }
        return answer;
    }

    public int countDays(int y,int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x]=true;
        int sum=board[y][x];

        while(!q.isEmpty()){
            int[] cur =q.poll();
            for(int dir=0; dir<4;dir++){
                int ny = dy[dir]+cur[0];
                int nx = dx[dir]+cur[1];
                if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if(visited[ny][nx] || board[ny][nx]==0) continue;
                sum+=board[ny][nx];
                q.offer(new int[]{ny,nx});
                visited[ny][nx]=true;
            }
        }
        return sum;
    }
}
