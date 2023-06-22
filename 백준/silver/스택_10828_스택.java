package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_10828_스택 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int n, m, t;
    public static int[][] arr;
    public static int[][] orders;
    public static int[] tmp;
    public static boolean[] visited;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while(t-->0){
            String[] orders = br.readLine().split(" ");
            if (orders.length == 1) {
                if (orders[0].equals("top")) {
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(stack.peek());
                    continue;
                } else if (orders[0].equals("size")) {
                    System.out.println(stack.size());
                    continue;
                } else if (orders[0].equals("empty")) {
                    int x = stack.isEmpty() ? 1 : 0;
                    System.out.println(x);
                    continue;
                } else {
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(stack.pop());
                    continue;
                }
            }
            stack.push(Integer.parseInt(orders[1]));
        }
    }
}
