package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_2573 {
    public static int n, m, r;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[][] visited;
    public static int[][] board;
    public static int answer;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m];

        for(int i=0 ;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year=0;
        while (true) {
            visited= new int[n][m];
            int cnt = countIce();
            if (cnt >= 2) {
                answer=year;
                break;
            }
            if (cnt == 0) {
                answer=0;
                break;
            }
            year++;

            meltIce();
        }
        System.out.println(answer);
    }

    private static void meltIce() {
        visited = new int[n][m];
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] != 0 || board[i][j] !=0) continue;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                visited[i][j]=1;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int ny = cur[0] + dy[dir];
                        int nx = cur[1] + dx[dir];
                        if(ny<0 || ny>=n ||nx<0 ||nx>=m) continue;
                        if(visited[ny][nx] != 0) continue;
                        if (board[ny][nx] == 0) {
                            q.offer(new int[]{ny, nx});
                            visited[ny][nx]=1;
                            continue;
                        }
                        if (board[ny][nx] > 0) {
                            board[ny][nx]--;
                            if(board[ny][nx]==0)
                                visited[ny][nx]=1;
                            continue;
                        }
                    }
                }
            }
        }
    }

    public static int countIce() {
        int cnt=0;
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(visited[i][j] !=0 || board[i][j]==0 )continue;
                cnt++;
                visited[i][j]=cnt;
                bfs(i,j,cnt);
            }
        }
        return cnt;
    }

    public static void bfs(int i, int j,int idx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0; dir<4;dir++){
                int ny = cur[0] + dy[dir];
                int nx = cur[1] + dx[dir];

                if(ny<0 || ny>n || nx<0 || nx >m) continue;
                if(visited[ny][nx] != 0 || board[ny][nx]==0) continue;
                visited[ny][nx]=idx;
                q.offer(new int[]{ny, nx});
            }
        }
    }
}
