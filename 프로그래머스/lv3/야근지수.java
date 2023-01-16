package ps.프로그래머스.lv3;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<works.length;i++){
            pq.offer(works[i]);
        }

        while(n>0){
            int cur = pq.poll();
            pq.offer(cur-1);
            n--;
        }

        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur<0) continue;
            answer+=cur*cur;
        }

        return answer;
    }
}
