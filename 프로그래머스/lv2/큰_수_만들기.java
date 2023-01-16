package ps.프로그래머스.lv2;

public class 큰_수_만들기 {
    /*
    lv2 그리디문제 중 첫 제출인데 못 풀겠어서 풀이를 확인하고 몇시간 뒤에 다시 풀었다
    후에 백준 그리디 유형을 실버부터 풀어볼 필요가 있다
     */
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int resultLen = number.length()-k;
        int index= 0;

        for(int i=0;i<resultLen;i++){
            int maxV=0;
            for(int j = index; j<=k+i; j++){
                if(number.charAt(j)-'0' > maxV){
                    index = j+1;
                    maxV = number.charAt(j)-'0';
                }
            }
            answer.append(maxV);
        }
        return answer.toString();
    }
}
