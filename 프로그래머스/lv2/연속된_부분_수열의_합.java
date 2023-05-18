package ps.프로그래머스.lv2;

public class 연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int answerLen = 1000010;
        int answerLo=0;
        int answerHi=0;

        int curSum=0;
        int lo=0, hi=1;
        curSum=sequence[lo];
        while(lo<= hi){
            // System.out.println("curSum: "+ curSum+ "lo: "+lo+"hi: "+hi);
            if(curSum< k){
                if(hi==sequence.length) break;
                curSum+=sequence[hi];
                hi++;
                continue;
            }
            else if(curSum == k){
                if(hi-lo < answerLen){
                    answerLen = hi-lo;
                    answerLo=lo;
                    answerHi=hi-1;
                }
                curSum-=sequence[lo];
                lo++;
            }else{
                curSum-=sequence[lo];
                lo++;
            }
        }
        answer = new int[]{answerLo,answerHi};

        return answer;
    }
}
