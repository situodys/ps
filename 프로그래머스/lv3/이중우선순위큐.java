package ps.프로그래머스.lv3;

import java.util.*;


public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {};

        Queue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minPq = new PriorityQueue<>();

        for(int i=0;i<operations.length;i++){
            String[] splited = operations[i].split(" ");

            if(splited[0].equals("I")){
                maxPq.add(Integer.parseInt(splited[1]));
                minPq.add(Integer.parseInt(splited[1]));
                continue;
            }
            if(maxPq.isEmpty() || minPq.isEmpty()){
                continue;
            }
            else if(splited[1].equals("1")){
                minPq.remove(maxPq.poll());
            }
            else{
                maxPq.remove(minPq.poll());
            }

        }
        answer = new int[]{0,0};
        if(maxPq.isEmpty() || minPq.isEmpty()){
            return answer;
        }

        answer[0] = maxPq.peek();
        answer[1]=minPq.peek();
        return answer;
    }
}
