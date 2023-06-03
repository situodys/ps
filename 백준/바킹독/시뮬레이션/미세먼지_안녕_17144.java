package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지_안녕_17144 {

    public static int n, m, t;
    public static int dy[] = {0, 1, 0, -1}; //, 1, 1, -1, -1
    public static int dx[] = {-1, 0, 1, 0}; //, 1, -1, 1, -1
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int ccy[] = {1,0,-1,0};
    public static int ccx[] = {0,1,0,-1};
    public static int cy[] = {-1,0,1,0};
    public static int cx[] = {0,1,0,-1};

    public static int answer = 0;
    public static int[][] board;
    public static int[][] tmp;
    public static Queue<int[]> dustLoc;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    //11:00
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        int[] upLoc = null;
        int[] lowLoc = null;
        dustLoc = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0) {
                    dustLoc.offer(new int[]{i, j});
                }
                if (board[i][j] == -1  ) {
                    if(upLoc == null) upLoc = new int[]{i, j};
                    else lowLoc = new int[]{i, j};
                }
            }
        }

        while (t-- > 0) {
            spreadDust();
            cleanerExecute(upLoc,lowLoc);
        }
        sumDust();
        System.out.println(answer);
    }

    private static void sumDust() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] <=0)continue;
                answer += board[i][j];
            }
        }
    }

    static void spreadDust() {
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] < 5) {
                    tmp[i][j] += board[i][j];
                    continue;
                }
                int v = board[i][j] / 5;
                for (int dir = 0; dir < 4; dir++) {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        continue;
                    }
                    if (board[ny][nx] == -1) {
                        continue;
                    }
                    tmp[ny][nx] += v;
                    board[i][j] -= v;
                }
                tmp[i][j] += board[i][j];
            }
        }
        board = tmp;
    }

    static void cleanerExecute(int[] up,int[] low) {
        cleanUp(up);
        cleanLow(low);
    }

    static void cleanUp(int[] start) {
        int dir=0;
        int y= start[0];
        int x = start[1];
        int prev = 0;
        int nxt = 0;

        while(dir<4){
            int ny= y+ ccy[dir];
            int nx= x+ ccx[dir];
            if(ny==start[0] && nx==start[1]) break;

            if (ny > start[0] || ny < 0 || nx < 0 || nx >= m) {
                dir++;
                dir%=4;
            }
            else{
                nxt=board[ny][nx];
                board[ny][nx]=prev;
                prev=nxt;
                y=ny;
                x=nx;
            }
        }
    }

    static void cleanLow(int[] start) {
        int dir=0;
        int y= start[0];
        int x = start[1];
        int prev = 0;
        int nxt = 0;

        while(dir<4){
            int ny= y+ cy[dir];
            int nx= x+ cx[dir];
            if(ny==start[0] && nx==start[1]) break;

            if (ny < start[0] || ny >= n || nx < 0 || nx >= m) {
                dir++;
                dir%=4;
            }
            else{
                nxt=board[ny][nx];
                board[ny][nx]=prev;
                prev=nxt;
                y=ny;
                x=nx;
            }
        }
    }
}
