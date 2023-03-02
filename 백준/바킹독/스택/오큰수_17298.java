package ps.백준.바킹독.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {

    public static int n, m;
    public static Stack<Integer> left,right;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        left = new Stack<>();
        right = new Stack<>();
        Stack ans = new Stack();

        for (int i = 0; i < n; i++) {
            left.push(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int cur = left.pop();
            while (!right.isEmpty()) {
                if (cur >= right.peek()) {
                    right.pop();
                    continue;
                }
                break;
            }
            if (right.isEmpty()) {
                ans.push(-1);
            }else{
                ans.push(right.peek());
            }
            right.push(cur);
        }

        while (!ans.isEmpty()) {
            sb.append(ans.pop());
            sb.append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
