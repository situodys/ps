package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기3_16933 {

    public static int n, m,k;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int[][][][]visited;
    public static int[][] board;
    public static int answer=Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[11][2][n][m];

        for (int i = 0; i < 11; i++) {
            visited[i][0][0][0]= 1;
        }

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }

        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int brokenWallCount = cur[0];
            int isNight = cur[1];
            int y = cur[2];
            int x = cur[3];

            int nxtNight = isNight == 0 ? 1 : 0;
            for(int dir=0; dir<4; dir++){
                int ny = y+ dy[dir];
                int nx = x+ dx[dir];

                if(ny< 0 || ny>=n || nx<0 ||nx>=m) continue;
                if (ny == n - 1 && nx == m - 1) {
                    answer = Math.min(answer, visited[brokenWallCount][isNight][y][x] + 1);
                    continue;
                }

                if (board[ny][nx] == 0 && visited[brokenWallCount][nxtNight][ny][nx]==0) {
                    q.offer(new int[]{brokenWallCount, nxtNight, ny, nx,});
                    visited[brokenWallCount][nxtNight][ny][nx] = visited[brokenWallCount][isNight][y][x]+1;
                    continue;
                }
            }

            if(brokenWallCount>=k) continue;

            for(int dir=0; dir<4; dir++){
                int ny = y+ dy[dir];
                int nx = x+ dx[dir];

                if(ny< 0 || ny>=n || nx<0 ||nx>=m) continue;

                if (board[ny][nx] == 1 && isNight==0 && visited[brokenWallCount+1][nxtNight][ny][nx] == 0) {
                    q.offer(new int[]{brokenWallCount+1, nxtNight, ny, nx});
                    visited[brokenWallCount+1][nxtNight][ny][nx] = visited[brokenWallCount][isNight][y][x]+1;
                    continue;
                }
                if (board[ny][nx] == 1 && isNight==1 && visited[brokenWallCount+1][nxtNight][ny][nx] == 0) {
                    q.offer(new int[]{brokenWallCount, nxtNight, y, x});
                    visited[brokenWallCount][nxtNight][y][x] = visited[brokenWallCount][isNight][y][x]+1;
                    continue;
                }
            }
        }
        if (answer == Integer.MAX_VALUE) {
            answer=-1;
        }
        System.out.println(answer);
    }
}
