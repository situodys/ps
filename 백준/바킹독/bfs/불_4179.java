package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_4179 {
    public static int r, c;
    public static int answer = 1;
    public static char board[][];
    public static int visited[][];
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        visited = new int[r][c];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'F') {
                    q.offer(new int[]{i, j});
                    visited[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'J') {
                    if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                        bw.write(String.valueOf(1));
                        bw.flush();
                        bw.close();
                        return;
                    }
                    q.offer(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int ny = dy[dir] + cur[0];
                int nx = dx[dir] + cur[1];

                if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
                    continue;
                }
                if (board[ny][nx] != '.' || visited[ny][nx] != 0) {
                    continue;
                }

                if (board[cur[0]][cur[1]] == 'J') {
                    if (ny == 0 || ny == r - 1 || nx == 0 || nx == c - 1) {
                        bw.write(String.valueOf(visited[cur[0]][cur[1]] + 1));
                        bw.flush();
                        bw.close();
                        return;
                    }
                    visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
                    board[ny][nx] = 'J';
                    q.offer(new int[]{ny, nx});
                } else {
                    visited[ny][nx] = -1;
                    board[ny][nx] = 'F';
                    q.offer(new int[]{ny, nx});
                }
            }
        }
        bw.write("IMPOSSIBLE");
        bw.flush();
        bw.close();
    }
}
