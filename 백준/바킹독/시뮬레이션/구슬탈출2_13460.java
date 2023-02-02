package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬탈출2_13460 {
    //2:52~
    public static int n, m;
    public static int answer=11;
    public static char[][] board;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};
    public static Loc red,blue;
    public static boolean isFinished=false;
    public static boolean isBlueInHole=false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for(int i=0; i<n;i++){
            String row = br.readLine();
            for(int j=0; j<m;j++){
                board[i][j]= row.charAt(j);
                if (board[i][j] == 'R') {
                    red = new Loc(i, j,'R');
                }
                if (board[i][j] == 'B') {
                    blue = new Loc(i, j,'B');
                }
            }
        }

        dfs(0);
        System.out.println(answer==11 ? -1 : answer);
    }

    public static void dfs(int cnt) {
        if(cnt==11||answer<=cnt)
            return;

        char[][] ori = new char[n][m];
        Loc redTmp = new Loc(red.y, red.x,'R');
        Loc blueTmp = new Loc(blue.y, blue.x,'B');
        copyBoard(board, ori);

        for(int dir=0; dir<4; dir++){
            move(dir);
            if (isBlueInHole) {
                isBlueInHole=false;
                isFinished=false;
                red.y = redTmp.y;
                red.x = redTmp.x;
                red.color = 'R';
                blue.y = blueTmp.y;
                blue.x = blueTmp.x;
                blue.color = 'B';
                copyBoard(ori,board);
                continue;
            }
            if (isFinished) {
                answer = Math.min(answer, cnt+1);
                isFinished=false;
                isBlueInHole=false;
                return;
            }
            dfs(cnt+1);
            red.y = redTmp.y;
            red.x = redTmp.x;
            red.color = 'R';
            blue.y = blueTmp.y;
            blue.x = blueTmp.x;
            blue.color = 'B';
            copyBoard(ori,board);
        }
    }

    public static void copyBoard(char[][] src, char[][] dst) {
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                dst[i][j]= src[i][j];
            }
        }
    }

    public static void move(int dir) {
        Loc[] orders = new Loc[2];
        decideOrder(orders,dir);
        roll(orders,dir);
    }

    private static void roll(Loc[] orders, int dir) {
        for(int i=0; i<2;i++){
            Loc cur= orders[i];
            board[cur.y][cur.x]='.';
            while(true){
                int ny= cur.y+dy[dir];
                int nx= cur.x+dx[dir];
                if(ny<0 || ny>=n ||nx<0||nx>=m) break;
                if(board[ny][nx]=='#' || board[ny][nx]=='R'|| board[ny][nx]=='B') break;
                if (board[ny][nx] == 'O') {
                    if (cur.color == 'R') {
                        isFinished=true;
                    }
                    if (cur.color == 'B') {
                        isBlueInHole =true;
                    }
                }
                cur.y = ny;
                cur.x = nx;
            }
            if(isBlueInHole || isFinished) continue;
            board[cur.y][cur.x] = cur.color;
        }
    }

    private static void decideOrder(Loc[] orders, int dir) {
        if (dir == 0) {
            if (red.y < blue.y) {
                orders[0] = red;
                orders[1] = blue;
                return;
            }
            orders[0] = blue;
            orders[1] = red;
        }
        if (dir == 1) {
            if (red.x < blue.x) {
                orders[0] = blue;
                orders[1] = red;
                return;
            }
            orders[0] = red;
            orders[1] = blue;
        }
        if (dir == 2) {
            if (red.y < blue.y) {
                orders[0] = blue;
                orders[1] = red;
                return;
            }
            orders[0] = red;
            orders[1] = blue;
        }
        if (dir == 3) {
            if (red.x < blue.x) {
                orders[0] = red;
                orders[1] = blue;
                return;
            }
            orders[0] = blue;
            orders[1] = red;
        }
    }

    public static class Loc{
        int y;
        int x;
        char color;

        public Loc(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color=color;
        }
    }
}
