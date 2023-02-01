package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
    //5:31~
    public static int n, m;
    public static int[][] board;
    public static boolean[][] visited;
    public static int answer = 0;
    public static int[] dy = {0, 0, -1, 1};
    public static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j]=true;
                dfs(i, j,1,board[i][j]);
                visited[i][j]=false;
                calExceptDfs(i, j, board[i][j]);
            }
        }

        System.out.println(answer);
    }

    private static void calExceptDfs(int i, int j, int val) {
        if (!(i + 1 >= n || i - 1 < 0 || j + 1 >= m)) {
            answer = Math.max(answer,
                    val +
                            board[i + 1][j] +
                            board[i - 1][j] +
                            board[i][j + 1]);
        }
        if (!(i + 1 >= n || j - 1 < 0 || j + 1 >= m)) {
            answer = Math.max(answer,
                    val +
                            board[i + 1][j] +
                            board[i][j-1] +
                            board[i][j + 1]);
        }
        if (!(i + 1 >= n || i - 1 < 0 || j - 1 <0)) {
            answer = Math.max(answer,
                    val +
                            board[i + 1][j] +
                            board[i - 1][j] +
                            board[i][j - 1]);
        }
        if (!(i - 1 < 0  || j - 1 < 0 || j + 1 >= m)) {
            answer = Math.max(answer,
                    val +
                            board[i - 1][j] +
                            board[i][j-1] +
                            board[i][j + 1]);
        }
        return;
    }

    public static void dfs(int y, int x, int cnt, int sum) {
        if (cnt == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) {
                continue;
            }
            visited[ny][nx] = true;
            dfs(ny, nx, cnt + 1, sum + board[ny][nx]);
            visited[ny][nx] = false;
        }

    }
}
