package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {
    public static char[][] board;
    public static int[][] visited;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};
    public static int n,m;
    public static int answer=0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new int[n][m];

        for(int i=0; i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = input.charAt(j);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='0' || visited[i][j] != 0) continue;
                q.offer(new int[]{i, j});
                visited[i][j]=1;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for(int dir=0;dir<4;dir++){
                        int ny= cur[0]+dy[dir];
                        int nx= cur[1]+dx[dir];

                        if(ny<0 ||ny>=n ||nx<0 || nx>=m) continue;
                        if(board[ny][nx]=='0' || visited[ny][nx] != 0)continue;
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = visited[cur[0]][cur[1]]+1;
                    }
                }
            }
        }
        System.out.println(visited[n-1][m-1]);

    }
}
