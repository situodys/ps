package programmers.lv2;

public class n제곱_배열_자르기 {

    private int getNum(long idx, int n) {
        long r = idx / n;
        long c = idx % n;
        return (int)((r>c?r:c)+1);
    }
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        for (long i = left; i <= right; i++) {
            answer[(int)(i-left)] = getNum(i, n);
        }
        return answer;
    }

    /*
    * public static int rowLen;
    public static int answerIdx=0;
    public static long RESTORE_ALL = -1;
    public static int[] answer;
    public int[] solution(int n, long left, long right) {
        answer = new int[(int)(right-left+1)];
        rowLen=n;

        int startIdx = (int)(left/n+1);
        int endIdx = (int)(right/n);

        restoreStart(makeArr(startIdx-1),(int)(left%n));
        for(int i=startIdx; i<endIdx;i++){
            restore(makeArr(i));
        }
        restoreLast(makeArr(endIdx),(int)(right%n)+1);

        return answer;
    }

    public int[] makeArr(int idx){
        int[] tmp = new int[rowLen];
        for(int i=0; i<rowLen;i++){
            if(i<idx){
                tmp[i] = idx+1;
                continue;
            }
            tmp[i]=i+1;
        }
        return tmp;
    }

    public void restoreStart(int [] tmp, int startIdx){
        for(int i=startIdx; i<tmp.length;i++){
            answer[answerIdx] = tmp[i];
            answerIdx++;
        }
        return;
    }

    public void restore(int [] tmp){
        for(int i=0; i<tmp.length;i++){
            answer[answerIdx] = tmp[i];
            answerIdx++;
        }
        return;
    }

    public void restoreLast(int [] tmp, int endIdx){
        for(int i=0; i<endIdx;i++){
            answer[answerIdx] = tmp[i];
            answerIdx++;
        }
        return;
    }
    * */
}
