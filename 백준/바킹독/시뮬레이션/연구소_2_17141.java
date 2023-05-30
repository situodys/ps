package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_2_17141 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int answer = 10000;
    public static int[][] board;
    public static List<int[]> cands;
    public static int[][] selected;
    public static int[][] visited;
    public static int validCnt=0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    //1700
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        cands = new ArrayList<>();
        selected = new int[m][2];

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    cands.add(new int[]{i, j});
                    board[i][j]=0;
                }
                if (board[i][j] == 0) {
                    validCnt++;
                }
            }
        }
        if (validCnt == 0 || validCnt==m) {
            System.out.println(0);
            return;
        }

        dfs(0, 0);
        if (answer == MAX_VAlUE) {
            answer = 0;
        }
        System.out.println(answer-1);
    }

    public static void dfs(int cnt, int idx) {
        if (cnt == m) {
            setBoard(selected, 2);
            bfs();
            setBoard(selected, 0);
            return;
        }

        for(int i=idx; i<cands.size(); i++){
            selected[cnt]=cands.get(i);
            dfs(cnt + 1, i+1);
        }
    }

    public static void setBoard(int[][] selected, int v) {
        for(int i=0; i<m;i++){
            int[] cur = selected[i];
            board[cur[0]][cur[1]]=v;
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited= new int[n][n];
        int cnt=0;
        int days=0;

        for (int[] s : selected) {
            q.offer(s);
            visited[s[0]][s[1]]=1;
            cnt++;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for(int dir=0;dir<4;dir++){
                int ny = dy[dir]+cur[0];
                int nx = dx[dir]+cur[1];
                if(ny<0 || ny>=n || nx<0 ||nx>=n) continue;
                if(visited[ny][nx] != 0 || board[ny][nx]!=0) continue;
                visited[ny][nx]=visited[cur[0]][cur[1]]+1;
                q.offer(new int[]{ny, nx});
                cnt++;
                days = Math.max(days, visited[ny][nx]);
            }
        }
        if (cnt == validCnt) {
            answer = Math.min(days, answer);
        }
    }
}
