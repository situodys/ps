package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀_3190 {
    //13:42~
    public static int n, k, l;
    public static int[][] board;
    public static Map<Integer, Character> dirInfos = new HashMap<>();
    public static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            dirInfos.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        Snake snake = new Snake(new Loc(0, 0, 1), new Loc(0, 0, 1));
        board[0][0] = 2;

        while (true) {
            answer++;
            if (!snake.run()) {
                break;
            }
            checkDirConvert(snake);
        }
        System.out.println(answer);
    }

    private static void checkDirConvert(Snake snake) {
        Character dir = dirInfos.get(answer);
        if(dir==null) return;
        snake.updateDir(dir);
    }

    public static class Snake {

        private Loc head;
        private Loc tail;
        private Queue<Loc> dirChanges;

        public Snake(Loc head, Loc tail) {
            this.head = head;
            this.tail = tail;
            dirChanges = new LinkedList<>();
        }

        public boolean run() {
            if (!head.move()) {
                return false;
            }
            if (!head.isApple()) {
                checkConvert();
                tail.updateBoard(0);
                tail.move();
            }
            head.updateBoard(2);
            return true;
        }

        public void checkConvert() {
            Loc cur = dirChanges.peek();
            if (cur != null && tail.isSamePosition(cur)) {
                tail.dir=cur.dir;
                dirChanges.poll();
            }
        }

        public void updateDir(char dir) {
            if (dir == 'L') {
                head.updateDirLeft();
            }
            if (dir == 'D') {
                head.updateDirRight();
            }
            dirChanges.offer(new Loc(head.y, head.x, head.dir));
        }
    }

    public static class Loc {
        private int y;
        private int x;
        private int dir;

        public Loc(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }

        public boolean validate() {
            if (y < 0 || y >= n || x < 0 || x >= n) {
                return false;
            }
            if (board[y][x] == 2) {
                return false;
            }
            return true;
        }

        public boolean move() {
            if (dir == 0) {
                moveN();
            } else if (dir == 1) {
                moveE();
            } else if (dir == 2) {
                moveS();
            } else {
                moveW();
            }
            return validate();
        }

        private void moveN() {
            y--;
        }

        private void moveE() {
            x++;
        }

        private void moveS() {
            y++;
        }

        private void moveW() {
            x--;
        }

        public boolean isApple() {
            return board[y][x] == 1;
        }

        public void updateBoard(int val) {
            board[y][x] = val;
        }

        public void updateDirLeft() {
            dir--;
            if(dir<0) dir=3;
        }

        public void updateDirRight() {
            dir = (dir+1)%4;
        }

        public boolean isSamePosition(Loc other) {
            return other.y == this.y && other.x == this.x;
        }
    }
}
