package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {
    public static int n,m,startY,startX,startDir;
    public static int board[][];
    public static int dy[] = new int[]{-1, 0, 1, 0};
    public static int dx[] = new int[]{0, 1, 0, -1};
    public static int answer =0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        startDir = Integer.parseInt(st.nextToken());
        Robot robot = new Robot(startY, startX, startDir);

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        robot.cleanRoom();
        System.out.println(answer);

    }

    public static class Robot {
        private int y;
        private int x;
        private int dir;

        public Robot(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }

        public void cleanRoom() {
            while (true) {
                answer++;
                cleanCurrentLoc();
                if(move()) continue;
                break;
            }
        }

        private boolean move() {
            while(true){
                for(int i=0; i<4;i++){
                    changeDir();
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if(ny<0 || ny>=n ||nx<0 ||nx>=m) continue;
                    if(board[ny][nx] != 0) continue;
                    y= ny;
                    x=nx;
                    return true;
                }

                if (!canMoveBack()) {
                    return false;
                }
                moveBack();
            }
        }

        private void moveBack() {
            int backDir = calBackDir();
            y = y + dy[backDir];
            x = x + dx[backDir];
        }

        private boolean canMoveBack() {
            int backDir= calBackDir();
            int ny = y + dy[backDir];
            int nx = x + dx[backDir];
            if(ny<0 || ny>=n || nx<0 ||nx>=m) return false;
            if(board[ny][nx]==1) return false;
            return true;
        }

        private int calBackDir() {
            if (dir == 0 || dir == 2) {
                return Math.abs(2 - dir);
            }
            return Math.abs(4 - dir);
        }

        private void changeDir() {
            this.dir--;
            if(dir<0) dir=3;
        }

        private void cleanCurrentLoc() {
            board[y][x] = 2;
        }
    }
}
