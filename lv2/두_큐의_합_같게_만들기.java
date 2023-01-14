package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 두_큐의_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();
        long leftSum = 0L;
        long rightSum = 0L;
        int cnt=0;

        leftSum = init(left,queue1);
        rightSum = init(right,queue2);

        while(leftSum != rightSum){
            cnt++;

            if(leftSum>rightSum){
                int tmp = left.poll();
                leftSum-=tmp;
                rightSum+=tmp;
                right.offer(tmp);
                continue;
            }
            int tmp = right.poll();
            rightSum-=tmp;
            leftSum+=tmp;
            left.offer(tmp);

            if(cnt> (queue1.length + queue2.length) * 2)
                return -1;
        }

        return cnt;
    }

    public long init(Queue<Integer> q, int[] target){
        long sum=0L;
        for(int i=0; i<target.length;i++){
            sum +=target[i];
            q.offer(target[i]);
        }
        return sum;
    }
}
