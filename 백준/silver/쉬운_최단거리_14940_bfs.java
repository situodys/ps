package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운_최단거리_14940_bfs {
    public static int n, m, p;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int answer = Integer.MAX_VALUE;
    public static int[][] board;
    public static int[][] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int ny = cur[0] + dy[dir];
                int nx = cur[1] + dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }
                if (visited[ny][nx] != -1 || board[ny][nx] == 0) {
                    continue;
                }
                visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{ny, nx});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] >= 0) {
                    System.out.print(visited[i][j] + " ");
                    continue;
                }

                if (board[i][j] == 0) {
                    visited[i][j] = 0;
                }
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }

    }
}
