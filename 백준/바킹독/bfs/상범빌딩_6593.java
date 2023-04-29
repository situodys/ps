package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩_6593 {

    public static int l, r, c;
    public static int dy[] = {0, 0, -1, 1, 0, 0};
    public static int dx[] = {1, -1, 0, 0, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[][][] visited;
    public static char[][][] board;
    public static int answer;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            visited = new int[l][r][c];
            board = new char[l][r][c];

            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String row = br.readLine();
                    for (int k = 0; k < c; k++) {
                        board[i][j][k] = row.charAt(k);
                        if (board[i][j][k] == 'S') {
                            q.offer(new int[]{i, j, k});
                            visited[i][j][k] = 1;
                        }
                    }
                }
                br.readLine();
            }

            boolean isEscape = false;
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int dir = 0; dir < 6; dir++) {
                    int nz = cur[0] + dz[dir];
                    int ny = cur[1] + dy[dir];
                    int nx = cur[2] + dx[dir];

                    if (nz < 0 || nz >= l || ny < 0 || ny >= r || nx < 0 || nx >= c) {
                        continue;
                    }
                    if (visited[nz][ny][nx] != 0 || board[nz][ny][nx] == '#') {
                        continue;
                    }
                    if (board[nz][ny][nx] == 'E') {
                        System.out.println("Escaped in " + visited[cur[0]][cur[1]][cur[2]] + " minute(s).");
                        isEscape = true;
                        break;
                    }
                    visited[nz][ny][nx] = visited[cur[0]][cur[1]][cur[2]] + 1;
                    q.offer(new int[]{nz, ny, nx});
                }
                if (isEscape) {
                    break;
                }
            }
            if (!isEscape) {
                System.out.println("Trapped!");
            }
        }

        System.out.println(sb);
    }
}
