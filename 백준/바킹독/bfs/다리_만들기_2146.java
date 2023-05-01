package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리_만들기_2146 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int[][] visited;
    public static int[][] board;
    public static int answer=Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int areaCnt = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 0 || board[i][j] == 0) {
                    continue;
                }
                areaCnt++;
                bfs(areaCnt, i, j);
            }
        }

        findShortestBridge();
        System.out.println(answer);
    }

    private static void findShortestBridge() {
        Queue<int[]> q = new LinkedList<>();
        int[][] dst = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                for (int dir = 0; dir < 4; dir++) {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if(ny<0 || ny>=n ||nx<0 ||nx>=n) continue;
                    if(board[ny][nx] != 0 || dst[ny][nx] != 0) continue;
                    dst[ny][nx]=1;
                    visited[ny][nx]=visited[i][j];
                    q.offer(new int[]{ny, nx});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int ny = dy[dir] + y;
                int nx = dx[dir] + x;
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                    continue;
                }
                if (visited[ny][nx] > 1 && visited[y][x] >1 && visited[ny][nx] != visited[y][x]) {
                    answer = Math.min(answer, dst[ny][nx] + dst[y][x]);
                    continue;
                }
                if(visited[ny][nx] > 0 )continue;
                dst[ny][nx] =dst[y][x]+1;
                visited[ny][nx] = visited[y][x];
                q.offer(new int[]{ny, nx});
            }
        }
    }

    private static void bfs(int areaCnt, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = areaCnt;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int ny = dy[dir] + y;
                int nx = dx[dir] + x;
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                    continue;
                }
                if (visited[ny][nx] != 0 || board[ny][nx] == 0) {
                    continue;
                }
                q.offer(new int[]{ny, nx});
                visited[ny][nx] = visited[y][x];
            }
        }
    }
}
