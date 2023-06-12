package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사탕_게임_3085_시뮬 {

    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{ -1, 1,0, 0};
    public static int n,m,t;
    public static char[][] board;
    public static int[][] visited;
    public static int answer=0;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for(int i=0; i<n;i++){
            String row = br.readLine();
            for(int j=0; j<n;j++){
                board[i][j] = row.charAt(j);
            }
        }
        countMaxLen();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if(board[i][j]==board[i][j+1]) continue;
                char tmp = board[i][j];
                board[i][j]=board[i][j+1];
                board[i][j+1]=tmp;
                countMaxLen();
                board[i][j+1]=board[i][j];
                board[i][j]=tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if(board[j][i]==board[j+1][i]) continue;
                char tmp = board[j][i];
                board[j][i]=board[j+1][i];
                board[j+1][i]=tmp;
                countMaxLen();
                board[j+1][i]=board[j][i];
                board[j][i]=tmp;
            }
        }

        System.out.println(answer);
    }

    private static void countMaxLen() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char std = board[i][j];
                int cnt=1;
                int idx=1;
                while(j+idx<n){
                    if (board[i][j + idx] == std) {
                        cnt++;
                        idx++;
                        continue;
                    }
                    break;
                }
                answer = Math.max(answer, cnt);
                j+=idx-1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char std = board[j][i];
                int cnt=1;
                int idx=1;
                while(j+idx<n){
                    if (board[j+idx][i] == std) {
                        cnt++;
                        idx++;
                        continue;
                    }
                    break;
                }
                answer = Math.max(answer, cnt);
                j+=idx-1;
            }
        }
    }
}
