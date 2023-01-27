package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위_굴리기_14499 {
    public static int n, m, r, c, t;
    public static int[][] board;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        Dice dice= new Dice(r,c);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int order =Integer.parseInt(st.nextToken());
            dice.roll(order);
        }
        System.out.println(sb.toString());
    }

    public static class Dice {
        private int y,x;
        private int floor, bottom;
        private int left, right;
        private int up, down;

        public Dice(int y, int x) {
            this.y=y;
            this.x=x;
            floor = 0;
            bottom = 0;
            left = 0;
            right = 0;
            up = 0;
            down = 0;
        }

        public void roll(int dir) {
            if (dir == 1) {
                if(!toEast()) return;
            }
            if (dir == 2) {
                if(!toWest()) return;
            }
            if (dir == 3) {
                if(!toNorth()) return;
            }
            if (dir == 4) {
                if(!toSouth()) return;
            }
            check();
            sb.append(this.floor).append("\n");
        }

        private boolean toEast() {
            if(x+1>=m) return false;
            int tmp=bottom;
            bottom=right;
            right=floor;
            floor=left;
            left=tmp;
            x++;
            return true;
        }
        private boolean toWest() {
            if(x-1<0) return false;
            int tmp=bottom;
            bottom=left;
            left=floor;
            floor=right;
            right=tmp;
            x--;
            return true;
        }
        private boolean toSouth() {
            if(y+1>=n) return false;
            int tmp=bottom;
            bottom=down;
            down=floor;
            floor=up;
            up=tmp;
            y++;
            return true;
        }
        private boolean toNorth() {
            if(y-1<0) return false;
            int tmp=bottom;
            bottom=up;
            up=floor;
            floor=down;
            down=tmp;
            y--;
            return true;
        }

        private void check() {
            if (board[y][x] == 0) {
                board[y][x] = this.bottom;
                return;
            }
            this.bottom=board[y][x];
            board[y][x]=0;
        }
    }
}
