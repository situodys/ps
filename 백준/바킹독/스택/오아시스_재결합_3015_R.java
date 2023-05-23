package ps.백준.바킹독.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오아시스_재결합_3015_R {

    public static int n, m, a, b, c;
    public static int dy[] = {0, 0, -1, 1, 0, 0};
    public static int dx[] = {1, -1, 0, 0, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[][] dp;
    public static int[] heights;
    public static long answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            int cnt=1;
            while (!stack.isEmpty() && stack.peek()[0] <= h) {
                answer += stack.peek()[1];
                if (stack.peek()[0] == h) {
                    cnt += stack.peek()[1];
                }
                stack.pop();
            }
            if(!stack.isEmpty()) answer++;
            stack.push(new int[]{h, cnt});
        }
        System.out.println(answer);
    }
}
