package ps.프로그래머스.lv3;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] board = new int[n][m];

        for(int[] puddle : puddles){
            board[puddle[1]-1][puddle[0]-1] = -1;
        }

        int status=1;
        for(int i=0; i<m;i++){
            if(board[0][i]==-1){
                status=0;
            }
            board[0][i]=status;
        }

        status=1;
        for(int i=0; i<n;i++){
            if(board[i][0]==-1){
                status=0;
            }
            board[i][0]=status;
        }


        for(int i=1; i<n;i++){
            for(int j=1; j<m;j++){
                if(board[i][j]==-1){
                    board[i][j]=0;
                    continue;
                }
                board[i][j]= (board[i-1][j]+board[i][j-1])%1000000007;
            }
        }

        return board[n-1][m-1];
    }
}
