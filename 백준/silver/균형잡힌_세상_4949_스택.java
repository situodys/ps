package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class 균형잡힌_세상_4949_스택 {
    public static int n, m, p;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static boolean[][] visited;
    public static char[][] board;
    public static boolean[] keys;
    public static List<int[]>[] locationsOfWall;
    public static int answer = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Character> brackets = new HashSet<>();
        brackets.add('(');
        brackets.add(')');
        brackets.add('[');
        brackets.add(']');


        while(true){
            Stack<Character> stk = new Stack<>();
            boolean isAnswer=true;
            String x = br.readLine();
            if(x.equals(".")) break;

            for(int i=0; i<x.length();i++){
                char cur = x.charAt(i);
                if (!brackets.contains(cur)) {
                    continue;
                }
                if (cur == '(' || cur == '[') {
                    stk.push(cur);
                    continue;
                }
                if (stk.isEmpty()) {
                    isAnswer=false;
                    break;
                }
                if (cur == ')') {
                    if (stk.peek() == '(') {
                        stk.pop();
                        continue;
                    }
                    isAnswer=false;
                    break;
                }
                if (cur == ']') {
                    if (stk.peek() == '[') {
                        stk.pop();
                        continue;
                    }
                    isAnswer=false;
                    break;
                }
            }
            if (!stk.isEmpty() || !isAnswer) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}
