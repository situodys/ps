package ps.프로그래머스.lv2;

import java.util.*;

public class 뒤에_있는_큰_수_찾기 {

    public static int[] tmp;
    public int[] solution(int[] numbers) {
        int[] answer = {};
        answer = new int[numbers.length];
        tmp = new int[numbers.length];

        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<numbers.length;i++){
            int cur = numbers[i];

            if(stack.isEmpty()){
                stack.push(new int[]{i,cur});
                continue;
            }
            while(!stack.isEmpty()){
                if(stack.peek()[1] < cur){
                    int[] top = stack.pop();
                    answer[top[0]] = cur;
                }
                else break;
            }
            stack.push(new int[]{i,cur});
        }
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            answer[top[0]]=-1;
        }
        return answer;
    }
}
