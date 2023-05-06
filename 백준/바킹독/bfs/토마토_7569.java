package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {

    public static int n, m, p;
    public static int dy[] = {0, 0, -1, 1,0,0};
    public static int dx[] = {1, -1, 0, 0,0,0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[][][] visited;
    public static int[][][] board;
    public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        board = new int[p][m][n];
        visited = new int[p][m][n];
        Queue<int[]> q = new LinkedList<>();
        int needToChangeTom = 0;
        int wall=0;
        int notNeedToChangeTom=0;

        for(int i=0; i<p; i++){
            for(int j=0; j<m; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k]==0) {
                        needToChangeTom++;
                    }
                    if (board[i][j][k] == -1) {
                        wall++;
                    }
                    if (board[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                        visited[i][j][k]=1;
                        notNeedToChangeTom++;
                    }
                }
            }
        }
        if (m*n*p==wall+notNeedToChangeTom) {
            System.out.println(0);
            return;
        }

        int changedTot=0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z= cur[0];
            int y= cur[1];
            int x = cur[2];

            for(int dir=0; dir<6; dir++){
                int nz=dz[dir]+z;
                int ny =dy[dir]+y;
                int nx = dx[dir]+x;

                if(ny<0 || ny>=m || nx< 0|| nx>=n || nz<0 || nz>=p) continue;
                if(visited[nz][ny][nx] != 0 || board[nz][ny][nx] == 1 || board[nz][ny][nx] ==-1) continue;
                q.offer(new int[]{nz, ny, nx});
                visited[nz][ny][nx]=visited[z][y][x]+1;
                answer = Math.max(answer, visited[nz][ny][nx]);
                changedTot++;
            }
        }
        if (changedTot != needToChangeTom) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer-1);
    }
}
