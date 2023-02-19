package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {

    public static int n,m;
    public static int answer=1;
    public static int board[][];
    public static int visited[][];
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1,1,0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int [n][m];
        visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    visited[i][j]=1;
                    q.offer(new int[]{i, j});
                }
                if (board[i][j] == -1) {
                    visited[i][j]=1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int ny= cur[0]+dy[dir];
                int nx= cur[1]+dx[dir];

                if(ny<0 || ny>=n || nx<0 ||nx>=m) continue;
                if(board[ny][nx]!=0 || visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[cur[0]][cur[1]]+1;
                q.offer(new int[]{ny, nx});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    bw.write(String.valueOf(-1));
                    bw.flush();
                    bw.close();
                    return;
                }
                answer = Math.max(answer, visited[i][j]);
            }
        }

        bw.write(String.valueOf(answer-1));
        bw.flush();
        bw.close();
    }
}
