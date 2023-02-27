package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림_1926 {
    public static int n, m;
    public static int maxArea;
    public static int[][] board;
    public static boolean[][] visited;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

        int idx=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || board[i][j] == 0) {
                    continue;
                }
                idx++;
                int cnt=1;
                maxArea = Math.max(maxArea, cnt);
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                visited[i][j]=true;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int ny = cur[0] + dy[dir];
                        int nx = cur[1] + dx[dir];
                        if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
                        if(visited[ny][nx] || board[ny][nx]==0) continue;
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx]=true;
                        cnt++;
                        maxArea = Math.max(maxArea, cnt);
                    }
                }
            }
        }

        bw.write(idx +"\n"+ maxArea);
        bw.flush();
        bw.close();
    }
}
