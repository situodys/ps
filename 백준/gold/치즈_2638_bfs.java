package ps.백준.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2638_bfs {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{ -1, 1,0, 0};
    public static int n,m,t;
    public static int[][] board;
    public static int[][] visited;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        int cheeseCnt =0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int day=0;

        while(true){
            visited = new int[n][m];
            q.offer(new int[]{0, 0});
            visited[0][0]= 1;
            if(cheeseCnt==0) break;

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for(int dir=0; dir<4;dir++){
                    int ny = dy[dir]+cur[0];
                    int nx = dx[dir]+cur[1];

                    if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
                    if(visited[ny][nx] != 0 && board[ny][nx]==0) continue;
                    if (board[ny][nx] == 1) {
                        if(visited[ny][nx]>=2) continue;
                        visited[ny][nx]++;
                        if (visited[ny][nx] == 2) {
                            board[ny][nx]=0;
                            cheeseCnt--;
                            continue;
                        }
                        continue;
                    }
                    q.offer(new int[]{ny, nx});
                    visited[ny][nx]++;
                }
            }
            day++;
        }
        System.out.println(day);
    }
}
