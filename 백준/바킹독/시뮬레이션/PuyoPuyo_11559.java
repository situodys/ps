package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PuyoPuyo_11559 {
    public static int n, m;
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};
    public static char[][] board = new char[12][6];
    public static boolean[][] visited = new boolean[12][6];
    public static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean didChange = false;

        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            board[i] = input.toCharArray();
        }

        do {
            didChange=false;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] == '.' || visited[i][j]) {
                        continue;
                    }
                    char standard = board[i][j];
                    Queue<int[]> q = new LinkedList<>();
                    List<int[]> cand = new ArrayList<>();
                    int[] loc = new int[]{i, j};
                    q.offer(loc);
                    cand.add(loc);
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int ny = cur[0] + dy[dir];
                            int nx = cur[1] + dx[dir];
                            if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6) {
                                continue;
                            }
                            if (board[ny][nx] != standard || visited[ny][nx]) {
                                continue;
                            }
                            int[] nxt = new int[]{ny, nx};
                            visited[ny][nx] = true;
                            q.offer(nxt);
                            cand.add(nxt);
                        }
                    }
                    if (cand.size() >= 4) {
                        bomb(cand);
                        didChange = true;
                    }
                }
            }
            if(didChange){
                updateBoard();
                answer++;
            }
        } while (didChange);

        System.out.println(answer);
    }

    public static void bomb(List<int[]> cand) {
        for (int[] loc : cand) {
            board[loc[0]][loc[1]] = 'X';
        }
    }

    public static void updateBoard() {
        char[][] tmp = new char[12][6];

        for (char[] row : tmp) {
            Arrays.fill(row, '.');
        }

        for (int i=0; i< 6; i++) {
            int idx = 11;
            for (int j = 11; j >= 0; j--) {
                if(board[j][i]=='X') continue;
                tmp[idx][i] = board[j][i];
                idx--;
            }
        }

        copyArr(tmp,board);
    }

    public static void copyArr(char[][] src, char[][] dst) {
        for(int i=0; i<12;i++){
            for(int j=0; j<6; j++){
                dst[i][j] = src[i][j];
            }
        }
    }
}
