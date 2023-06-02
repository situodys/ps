package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class 배열_돌리기_1 {

    public static int n,m,t;
    public static int dy[] = {0, 1, 0, -1}; //, 1, 1, -1, -1
    public static int dx[] = {-1, 0, 1, 0}; //, 1, -1, 1, -1
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int answer = 0;
    public static int[][] board;
    public static int[][] tmp;
    public static Queue<int[]> q;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    //12:00
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int innerCnt= Math.min(n,m)/2;

        for(int i=0; i<innerCnt; i++){
            int rotCnt = t %(2 * (n - i*2) + 2 * (m - i*2) - 4);
            while(rotCnt-->0){
                rotate(i,i,0,board[i][i],i,0);
            }
        }

        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void rotate(int y, int x, int dir,int prev, int order,int cnt) {
        if (cnt > 2 * (n - order * 2) + 2 * (m - order * 2)-4) {
            return;
        }
        int cur = board[y][x];
        board[y][x]=prev;
        int ny= y+dy[dir];
        int nx= x+dx[dir];
        if (ny < order || ny >= n - order || nx < order || nx >= m - order) {
            dir++;
            dir%=4;
            ny = y + dy[dir];
            nx = x + dx[dir];
            rotate(ny, nx, dir, cur, order,cnt+1);
        } else {
            rotate(ny, nx, dir, cur,order,cnt+1);
        }
    }
}
