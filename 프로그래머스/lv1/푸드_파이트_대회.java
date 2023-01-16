package ps.프로그래머스.lv1;

public class 푸드_파이트_대회 {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder head = new StringBuilder();
        StringBuilder tail = new StringBuilder();

        for(int i=1; i<food.length;i++){
            for(int j=0;j< food[i]/2; j++){
                head.append(i);
                tail.append(i);
            }
        }

        head.append(0);
        answer = head.append(tail.reverse()).toString();
        return answer;
    }
}
