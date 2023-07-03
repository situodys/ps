package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 제로_10773_스택 {
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

        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<n;i++){
            int cur = Integer.parseInt(br.readLine());
            if (cur == 0) {
                stk.pop();
                continue;
            }
            stk.push(cur);
        }

        while (!stk.isEmpty()) {
            answer += stk.pop();
        }

        System.out.println(answer);
    }
}
