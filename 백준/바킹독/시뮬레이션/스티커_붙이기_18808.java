package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_붙이기_18808 {

    public static int n, m, k, r, c;
    public static int[][] board;
    public static int[][] sticker;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        int answer = 0;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            sticker = new int[r][c];
            boolean didAttach = false;

            for (int row = 0; row < r; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < c; col++) {
                    sticker[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            for (int rot = 0; rot < 4; rot++) {
                for (int row = 0; row <= n - r; row++) {
                    for (int col = 0; col <= m - c; col++) {
                        if (isPossibleToAttach(row, col)) {
                            putSticker(row, col);
                            didAttach = true;
                            break;
                        }
                    }
                    if (didAttach) {
                        break;
                    }
                }
                if (didAttach) {
                    break;
                }
                rotateSticker();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void rotateSticker() {
        int[][] tmp = new int[r][c];
        int swapTmp = r;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tmp[i][j] = sticker[i][j];
            }
        }

        sticker = new int[c][r];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                sticker[i][j] = tmp[r - 1 - j][i];
            }
        }
        r = c;
        c = swapTmp;
        return;
    }

    private static void putSticker(int sy, int sx) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(sticker[i][j]==1){
                    board[i + sy][j + sx] = sticker[i][j];
                }
            }
        }
        return;
    }

    private static boolean isPossibleToAttach(int sy, int sx) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] == 1 && board[i + sy][j + sx] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
