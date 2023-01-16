package ps.프로그래머스.lv2;
import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> arr = new LinkedList<>();
        ArrayList<Integer> tmp = new ArrayList<>();

        int diff=0;
        for(int i=0;i<progresses.length;i++){
            diff = 100 -progresses[i];
            arr.offer(diff%speeds[i] == 0 ? diff/speeds[i] : diff/speeds[i]+1);
        }


        int cur = arr.poll();
        int nxt=0;
        int cnt=1;

        while(!arr.isEmpty()){
            nxt = arr.poll();
            if(cur < nxt){
                tmp.add(cnt);
                cnt=1;
                cur =nxt;
                continue;
            }
            cnt++;
        }
        tmp.add(cnt);

        answer = new int[tmp.size()];

        for(int i=0;i<tmp.size();i++){
            answer[i]= tmp.get(i);
        }


        return answer;
    }
}
