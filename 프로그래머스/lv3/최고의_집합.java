package ps.프로그래머스.lv3;

public class 최고의_집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if(s<n){
            return new int[]{-1};
        }

        int idx=0;
        while(n>0){
            int cur = s/n;
            answer[idx]=cur;
            s-=cur;
            n--;
            idx++;
        }

        return answer;
    }
}
