package ps.프로그래머스.lv2;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int minIdx=0;
        int maxIdx = people.length-1;

        Arrays.sort(people);
        int curSum = people[maxIdx]+people[minIdx];

        while(maxIdx>=0 && minIdx<=maxIdx){
            if(minIdx == maxIdx) {
                System.out.println("same");
                answer++;
                break;
            }
            if(curSum<=limit){
                minIdx++;
                curSum+=people[minIdx];
                continue;
            }
            answer++;
            maxIdx--;
            curSum = people[minIdx]+people[maxIdx];
        }

        return answer;
    }
}
