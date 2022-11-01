package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오_프렌즈_컬리링북 {
    public static int[] dy= {0,1,0,-1};
    public static int[] dx= {1,0,-1,0};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int currentSize=0;

        int visited[][]= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=-1;
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]==0 || visited[i][j] != -1) continue;
                numberOfArea++;
                currentSize=1;
                q.offer(new int[]{i,j});
                visited[i][j]=numberOfArea;
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int curY=cur[0]; int curX = cur[1];
                    for(int dir=0;dir<4;dir++){
                        int ny = curY+dy[dir];
                        int nx = curX+dx[dir];
                        if(ny<0 || ny>=m ||nx<0 || nx>=n) continue;
                        if(visited[ny][nx] != -1|| picture[ny][nx] ==0) continue;
                        if(picture[curY][curX] != picture[ny][nx]) continue;
                        currentSize++;
                        visited[ny][nx] = numberOfArea;
                        q.offer(new int[]{ny,nx});
                    }
                }
                maxSizeOfOneArea = Math.max(currentSize,maxSizeOfOneArea);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
