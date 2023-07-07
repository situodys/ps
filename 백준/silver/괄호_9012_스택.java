package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호_9012_스택 {
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{ 0,-1, 0, 1};
    public static int n, m, t;
    public static int[][] board;
    public static boolean[][]visited;
    public static int answer;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n;i++){
            String x = br.readLine();
            Stack<Character> stk = new Stack<>();
            boolean isRight=true;
            for (char c : x.toCharArray()) {
                if (c == '(') {
                    stk.add(c);
                    continue;
                }
                else{
                    if (stk.isEmpty()) {
                        isRight=false;
                        break;
                    }
                    stk.pop();
                }
            }
            if (!isRight || !stk.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
