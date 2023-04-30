package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기_2206 {


    public static int n,m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int[][][] visited;
    public static char[][] board;
    public static int answer;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new int[2][n][m];

        for(int i=0; i<n;i++){
            String row = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = row.charAt(j);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0,0});
        visited[0][0][0]= 1;
        visited[1][0][0]= 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y= cur[0];
            int x = cur[1];
            int didBreak = cur[2];

            for(int dir=0; dir<4;dir++){
                int ny = y+dy[dir];
                int nx = x+dx[dir];

                if(ny< 0|| ny>=n ||nx<0 ||nx>=m) continue;
                if(visited[didBreak][ny][nx] != 0) continue;
                if (ny == n - 1 && nx == m - 1) {
                    if (board[ny][nx] == '1') {
                        if(didBreak != 0) continue;
                        System.out.println(visited[0][y][x]+1);
                        return;
                    }
                    if (didBreak == 0) {
                        System.out.println(visited[0][y][x]+1);
                        return;
                    }
                    System.out.println(visited[1][y][x]+1);
                    return;
                }
                if (board[ny][nx] == '1') {
                    if(didBreak != 0) continue;
                    visited[1][ny][nx] = visited[0][y][x]+1;
                    q.offer(new int[]{ny, nx, 1});
                    continue;
                }
                visited[didBreak][ny][nx]=visited[didBreak][y][x]+1;
                q.offer(new int[]{ny, nx,didBreak});
            }
        }
        if (n == 1 && m == 1 && board[0][0] == '0') {
            System.out.println(1);
            return;
        }
        System.out.println(-1);
    }
}
