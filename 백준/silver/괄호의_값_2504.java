package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호의_값_2504 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{ -1, 1,0, 0};
    public static int n,m,t;
    public static int[][] board;
    public static int[][] visited;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        String target = br.readLine();
        int answer=0;
        int tmp=1;

        for(int i=0; i<target.length(); i++){
            char cur = target.charAt(i);
            if (cur == '(' || cur == '[') {
                stack.push(cur);
                if(cur=='(') tmp*=2;
                else tmp*=3;
                continue;
            }
            if (stack.isEmpty()) {
                answer=0;
                break;
            }
            if (cur == ')') {
                if (stack.peek() != '(') {
                    answer=0;
                    break;
                }
                if (target.charAt(i - 1) == '(') {
                    answer+=tmp;
                }
                tmp/=2;
            }

            if (cur == ']') {
                if (stack.peek() != '[') {
                    answer=0;
                    break;
                }
                if (target.charAt(i - 1) == '[') {
                    answer+=tmp;
                }
                tmp/=3;
            }
            stack.pop();
        }
        if(!stack.isEmpty())
            answer=0;
        System.out.println(answer);
    }
}
