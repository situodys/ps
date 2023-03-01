package ps.백준.바킹독.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493_R {

    public static int n, m;
    public static Stack<Integer> stack;
    public static int[] towers;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        towers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        int cur;
        stack = new Stack<>();
        stack.push(0);
        int idx=1;
        bw.write("0 ");

        for (int i = 1; i < n; i++) {

            cur = towers[i];
            while (!stack.isEmpty()) {
                if (towers[stack.peek()] < cur) {
                    stack.pop();
                    continue;
                }
                break;
            }
            if (stack.isEmpty()) {
                stack.push(i);
                bw.write("0 ");
                continue;
            }
            bw.write(stack.peek()+1+" ");
            stack.push(i);
        }

        bw.flush();
        bw.close();
    }
}
