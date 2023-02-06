package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로_14890 {

    public static int n,l;
    public static int[][] board;
    public static int answer;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0 ;i<n;i++){
            for (int j = 0; j < n; j++) {
                int curVal = board[i][j];
                int len = 1;
                int idx =j+1;
                boolean canCross=true;
                while(true){
                    if(idx >= n) break;
                    if(board[i][idx]== curVal){
                        idx++;
                        len++;
                        continue;
                    }
                    if (board[i][idx] > curVal) {
                        if(board[i][idx] -curVal >1) {
                            canCross = false;
                            break;
                        }
                        if(len >=l){
                            idx++;
                            len=1;
                            curVal=curVal+1;
                            continue;
                        }
                        canCross=false;
                        break;
                    }
                    if (board[i][idx] < curVal) {
                        if(board[i][idx] - curVal != -1) {
                            canCross=false;
                            break;
                        }
                        for(int k=0; k<l;k++){
                            if(k+idx >=n || board[i][k+idx] != curVal-1){
                                canCross=false;
                                break;
                            }
                        }
                        curVal-=1;
                        len=0;
                        idx+=l;
                        continue;
                    }
                }
                if(canCross){
                    answer++;
                    j=idx-1;
                    continue;
                }
                break;
            }
        }

        for(int i=0 ;i<n;i++){
            for (int j = 0; j < n; j++) {
                int curVal = board[j][i];
                int len = 1;
                int idx =j+1;
                boolean canCross=true;
                while(true){
                    if(idx >= n) break;
                    if(board[idx][i]== curVal){
                        idx++;
                        len++;
                        continue;
                    }
                    if (board[idx][i] > curVal) {
                        if(board[idx][i] -curVal >1) {
                            canCross = false;
                            break;
                        }
                        if(len >=l){
                            idx++;
                            len=1;
                            curVal=curVal+1;
                            continue;
                        }
                        canCross=false;
                        break;
                    }
                    if (board[idx][i] < curVal) {
                        if(board[idx][i] - curVal != -1) {
                            canCross=false;
                            break;
                        }
                        for(int k=0; k<l;k++){
                            if(k+idx >=n || board[k+idx][i] != curVal-1){
                                canCross=false;
                                break;
                            }
                        }
                        curVal-=1;
                        len=0;
                        idx+=l;
                        continue;
                    }
                }
                if(canCross){
                    answer++;
                    j=idx-1;
                    continue;
                }
                break;
            }
        }
        System.out.println(answer);
    }
}
