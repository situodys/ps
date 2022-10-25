package programmers.lv2;

import java.util.ArrayList;

public class 행렬_테두리_회전하기 {

    //12:33~13:31, 회전하는 방법 알아두기
    public static int[][] board;
    public static ArrayList<Integer> minVals;
    public int[] solution(int rows, int columns, int[][] queries) {

        board = new int[rows+1][columns+1];
        minVals = new ArrayList<>();

        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                board[i][j]=(i-1)*columns+j;
            }
        }

        for(int i=0;i<queries.length;i++){
            rotate(queries[i]);
        }

        int[] answer = {};
        answer = new int[minVals.size()];
        for(int i=0;i<minVals.size();i++){
            answer[i]=minVals.get(i);
        }
        return answer;
    }

    public void rotate(int[] query){
        int minVal=10001;
        int startY = query[0];
        int startX = query[1];
        int endY = query[2];
        int endX = query[3];

        int tmp=board[startY][startX];
        minVal=tmp;

        for(int i=startY; i<endY;i++){
            board[i][startX] = board[i+1][startX];
            if(board[i][startX]<minVal)
                minVal=board[i][startX];
        }
        for(int i=startX; i<endX;i++){
            board[endY][i] = board[endY][i+1];
            if(board[endY][i]<minVal)
                minVal=board[endY][i];
        }
        for(int i= endY; i>startY; i--){
            board[i][endX] = board[i-1][endX];
            if(board[i][endX]<minVal)
                minVal=board[i][endX];
        }
        for(int i= endX; i>startX; i--){
            board[startY][i] = board[startY][i-1];
            if(board[startY][i]<minVal)
                minVal=board[startY][i];
        }
        board[startY][startX+1]=tmp;
        minVals.add(minVal);
    }
}
