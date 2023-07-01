package ps.백준.바킹독.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_수열_1874 {
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
        StringBuilder sb = new StringBuilder();

        int loc= 0;
        for(int i=0; i<n;i++){
            int cur = Integer.parseInt(br.readLine());

            if(cur > loc){
                for(int j= loc+1; j<=cur; j++){
                    stk.push(j);
                    sb.append("+").append("\n");
                }
                loc=cur;
            } else if (stk.peek() != cur) {
                System.out.println("NO");
                return;
            }
            stk.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
