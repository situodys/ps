package programmers.lv2;

public class 쿼드압축_후_개수_세기 {
    public static int zeroCnt=0;
    public static int oneCnt=0;
    public int[] solution(int[][] arr) {
        int[] answer = {};

        zip(0,0,arr.length,arr);

        answer= new int[]{zeroCnt,oneCnt};
        return answer;
    }

    public void zip(int y, int x,int len, int[][] arr){
        if(isOneValue(y,x,len,arr)){
            if(arr[y][x] == 1)
                oneCnt++;
            else zeroCnt++;
            return;
        }

        zip(y,x,len/2,arr);
        zip(y+len/2,x,len/2,arr);
        zip(y,x+len/2,len/2,arr);
        zip(y+len/2,x+len/2,len/2,arr);
    }

    public boolean isOneValue(int y, int x, int len, int[][] arr){
        int value = arr[y][x];
        for(int i=y;i<y+len;i++){
            for(int j=x;j<x+len; j++){
                if(arr[i][j] != value)
                    return false;
            }
        }
        return true;
    }
}
