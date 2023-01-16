package ps.프로그래머스.lv2;

import java.util.Stack;

public class 택배상자 {

    public static int cur=1;
    public static Stack<Integer> st = new Stack<>();

    //1 2 3 4 5
    public int solution(int[] order) {
        int answer = 0;

        for(int i=0;i<order.length;i++){
            if(order[i] > cur){
                move2con(order[i]);
                answer++;
                cur++;
                continue;
            }
            if(order[i] < cur){
                if(st.isEmpty() || st.peek() != order[i]){
                    break;
                }
                st.pop();
                answer++;
                continue;
            }
            cur++;
            answer++;
        }

        return answer;
    }
    public void move2con(int target){
        while(cur != target){
            st.push(cur);
            cur++;
        }
    }
}
