package programmers.lv1;

public class 콜라_문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(n>=a){
            answer += (n/a) *b;

            n = ((n/a)*b)+(n%a);
        }

        return answer;
    }
}
