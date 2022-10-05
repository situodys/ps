package programmers.lv2;
import java.util.*;

public class 더맵게 {

    public int solution(int[] scoville, int k) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<scoville.length;i++){
            pq.offer(scoville[i]);
        }

        int p1,p2;
        while(pq.size()>=2){
            p1 = pq.poll();
            p2 = pq.poll();
            if(p1 <k || p2< k){
                pq.offer(p1+p2*2);
                answer++;
                continue;
            }
            break;
        }
        if(pq.size()==1){
            if(pq.peek()<k) answer=-1;
        }

        return answer;
    }
}
