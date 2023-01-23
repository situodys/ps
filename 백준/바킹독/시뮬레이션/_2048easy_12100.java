package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2048easy_12100 {
    public static int n;
    public static int[][] board;
    public static int answer =0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int cnt){
        if(cnt==5){
            countMax();
            return;
        }

        int[][] tmp = new int[n][n];
        for(int dir=0; dir<4;dir++){
            copy(tmp,board);
            slide(dir);
            dfs(cnt+1);
            copy(board,tmp);
        }
    }

    private static void copy(int[][] dst, int[][] src){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dst[i][j]=src[i][j];
            }
        }
    }

    private static void countMax() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] > answer)
                    answer = board[i][j];
            }
        }
    }

    private static void slide(int dir) {
        if(dir==0){
            slideLeft();
            return;
        }
        if(dir==1){
            slideDown();
            return;
        }
        if(dir==2){
            slideRight();
            return;
        }
        if(dir==3){
            slideUp();
            return;
        }
    }

    private static void slideUp() {
        int[][] tmp = new int[n][n];

        for(int i=0; i<n;i++){
            int idx=0;
            for(int j=0;j <n;j++){
                if(board[j][i] ==0) continue;
                if(tmp[idx][i] ==0){
                    tmp[idx][i] = board[j][i];
                    continue;
                }
                if (tmp[idx][i] == board[j][i]) {
                    tmp[idx][i] = board[j][i]*2;
                    idx++;
                    continue;
                }
                idx++;
                tmp[idx][i] = board[j][i];
            }
        }
        copy(board,tmp);
    }

    private static void slideRight() {
        int[][] tmp = new int[n][n];

        for(int i=0;i<n;i++){
            int idx=n-1;
            for(int j=n-1;j>=0;j--){
                if(board[i][j]==0) continue;
                if(tmp[i][idx]==0){
                    tmp[i][idx] = board[i][j];
                    continue;
                }
                if(tmp[i][idx] == board[i][j]){
                    tmp[i][idx] = board[i][j]*2;
                    idx--;
                    continue;
                }
                idx--;
                tmp[i][idx]= board[i][j];
            }
        }

        copy(board,tmp);
    }

    private static void slideDown() {
        int[][] tmp = new int[n][n];

        for(int i=0; i<n;i++){
            int idx = n-1;
            for(int j=n-1; j>=0;j--){
                if(board[j][i]==0) continue;
                if(tmp[idx][i] == 0){
                    tmp[idx][i] = board[j][i];
                    continue;
                }
                if(tmp[idx][i] == board[j][i]){
                    tmp[idx][i] = board[j][i]*2;
                    idx--;
                    continue;
                }
                idx--;
                tmp[idx][i] = board[j][i];
            }
        }
        copy(board,tmp);
    }

    private static void slideLeft() {
        int[][] tmp = new int[n][n];

        for(int i=0;i<n;i++){
            int idx=0;
            for(int j=0;j<n;j++){
                if(board[i][j]==0) continue;
                if(tmp[i][idx] == 0){
                    tmp[i][idx] =board[i][j];
                    continue;
                }
                if (tmp[i][idx] == board[i][j]) {
                    tmp[i][idx] = board[i][j]*2;
                    idx++;
                    continue;
                }
                idx++;
                tmp[i][idx] = board[i][j];
            }
        }
        copy(board,tmp);
    }
}
