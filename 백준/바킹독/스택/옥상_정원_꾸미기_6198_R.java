package ps.백준.바킹독.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 옥상_정원_꾸미기_6198_R {

    public static int n, m;
    public static Stack<Integer> stack;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        stack = new Stack<>();

        int curHeight;
        for (int i = 0; i < n; i++) {
            curHeight = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= curHeight) {
                stack.pop();
            }
            answer += stack.size();
            stack.push(curHeight);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
