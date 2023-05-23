package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구_이동_16234 {

    public static int n, m, l;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[][] board;
    public static boolean[][] visited;
    public static List<int[]>[] unions;
    public static int[] sums;
    public static long answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int days=0;
        while(true){
            int idx=1;
            unions = new List[n*n+1];
            visited = new boolean[n][n];
            for(int i=1; i<n*n+1;i++){
                unions[i] = new ArrayList<>();
            }
            sums = new int[n * n+1];
            boolean isEnd=true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]) continue;
                    int cnt = bfs(idx,i,j);
                    idx++;
                    if(cnt>1) isEnd=false;
                }
            }
            if(isEnd) break;

            move();

            days++;

        }

        System.out.println(days);
    }

    private static void move() {
        for(int i=0; i<n*n;i++){
            List<int[]> u = unions[i+1];
            int len = u.size();
            if(len<=1) continue;
            int humans = sums[i + 1];
            int nxtValue = humans/len;
            for (int[] loc : u) {
                board[loc[0]][loc[1]] = nxtValue;
            }
        }
    }

    public static int bfs(int idx, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x]=true;
        unions[idx].add(new int[]{y, x});
        sums[idx] += board[y][x];
        int cnt=1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int curY=cur[0];
            int curX =cur[1];

            for(int dir=0; dir<4;dir++){
                int ny = curY+dy[dir];
                int nx = curX+dx[dir];
                if(ny<0 || ny>=n || nx<0 ||nx>=n) continue;
                if(visited[ny][nx]) continue;
                int diff = Math.abs(board[ny][nx] - board[curY][curX]);
                if(diff > l || diff<m ) continue;
                q.offer(new int[]{ny, nx});
                visited[ny][nx]=true;
                unions[idx].add(new int[]{ny, nx});
                cnt++;
                sums[idx] += board[ny][nx];
            }
        }
        return cnt;
    }
}
