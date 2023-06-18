package ps.백준.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 문자열_폭발_9935_스택 {
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

        String target = br.readLine();
        String x = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < target.length(); i++) {
            stack.push(target.charAt(i));

            int cnt=0;
            if (stack.size() >= x.length()) {
                for(int j=x.length()-1; j>=0; j--){
                    if (x.charAt(j) == stack.get(stack.size() - 1 - cnt)) {
                        cnt++;
                        continue;
                    }
                    break;
                }
                if (cnt == x.length()) {
                    for(int j=0; j<cnt;j++){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length()==0 ? "FRULA":sb);
    }
}
