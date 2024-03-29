package ps.프로그래머스.lv2;

import java.util.Stack;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return ans;
    }
}
