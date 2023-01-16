package ps.프로그래머스.lv2;
import java.util.*;

public class 프린터 {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Pair> q = new LinkedList<>();
        int[] sorted = priorities;
        int len =priorities.length;
        int idx = len-1;

        for(int i=0;i<len;i++){
            q.offer(new Pair(i,priorities[i]));
        }

        Arrays.sort(sorted);

        Pair cur;
        while(true){
            cur = q.poll();
            if(cur.location == location && cur.value == sorted[idx]){
                answer++;
                break;
            }
            if(cur.value < sorted[idx]){
                q.offer(cur);
                continue;
            }
            if(cur.value == sorted[idx] && cur.location != location){
                idx--;
                answer++;
                continue;
            }

        }

        return answer;
    }

    class Pair {
        public int location;
        public int value;

        public Pair(int location, int value){
            this.location = location;
            this.value = value;
        }
    }
}
