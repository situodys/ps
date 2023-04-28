package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_5427 {

    public static int n, m, r;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int[][] visited;
    public static char[][] board;
    public static int answer;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            board = new char[n][m];
            visited = new int[n][m];
            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                String row = br.readLine();
                for (int j = 0; j < m; j++) {
                    board[i][j] = row.charAt(j);
                    if (board[i][j] == '@') {
                        q.offer(new int[]{i, j});
                        visited[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == '*') {
                        q.offer(new int[]{i, j});
                        visited[i][j] = -1;
                    }
                }
            }
            boolean isPossible =false;
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int ny = cur[0] + dy[dir];
                    int nx = cur[1] + dx[dir];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        if(visited[cur[0]][cur[1]] == -1 || board[cur[0]][cur[1]]=='#') continue;
                        answer = visited[cur[0]][cur[1]];
                        sb.append(answer).append('\n');
                        isPossible=true;
                        break;
                    }

                    if(visited[ny][nx] == -1 || board[ny][nx]=='#') continue;
                    if(visited[ny][nx] != 0 && visited[cur[0]][cur[1]] >0 ) continue;
                    if (visited[cur[0]][cur[1]] == -1) {
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx]=-1;
                        continue;
                    } else {
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
                    }
                }
                if(isPossible)break;
            }

            if (!isPossible) {
                sb.append("IMPOSSIBLE").append('\n');
            }
        }
        System.out.println(sb);
    }
}
