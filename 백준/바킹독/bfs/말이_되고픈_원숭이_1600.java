package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이_되고픈_원숭이_1600 {

    public static int n, m,k;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int horseDy[] = {-1,-2,-2,-1,1,2,2,1};
    public static int horseDx[] = {-2,-1,1,2,2,1,-1,-2};
    public static int[][][] visited;
    public static int[][] board;
    public static int answer=Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        visited = new int[31][n][m];
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (n == 1 && m == 1 && board[0][0] == 0) {
            System.out.println(0);
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        for(int i=0; i<30; i++){
            visited[i][0][0]=1;
        }


        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int horseWalkCount = cur[2];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(ny <0 || ny>=n || nx<0 ||nx>=m) continue;
                if(board[ny][nx]==1) continue;
                if(visited[horseWalkCount][ny][nx] != 0 ) continue;
                if (ny == n - 1 && nx == m - 1) {
                    answer = Math.min(answer, visited[horseWalkCount][y][x]);
                    continue;
                }
                q.offer(new int[]{ny, nx, horseWalkCount});
                visited[horseWalkCount][ny][nx] = visited[horseWalkCount][y][x] + 1;
            }

            if(horseWalkCount >= k) continue;

            for(int dir=0; dir<8; dir++){
                int ny = y + horseDy[dir];
                int nx = x + horseDx[dir];
                if(ny <0 || ny>=n || nx<0 ||nx>=m) continue;
                if(board[ny][nx]==1) continue;
                if(visited[horseWalkCount+1][ny][nx] != 0 ) continue;
                if (ny == n - 1 && nx == m - 1) {
                    answer = Math.min(answer, visited[horseWalkCount][y][x]);
                    continue;
                }
                q.offer(new int[]{ny, nx, horseWalkCount+1});
                visited[horseWalkCount+1][ny][nx] = visited[horseWalkCount][y][x] + 1;
            }
        }

        if(answer == Integer.MAX_VALUE) answer=-1;
        System.out.println(answer);
    }
}
