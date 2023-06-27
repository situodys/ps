package ps.백준.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 대소문자_바꾸기_2744 {
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{ 0,-1, 0, 1};
    public static int n, m, t;
    public static int[][] board;
    public static int answer;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String x = br.readLine();
        for (int i = 0; i < x.length(); i++) {
            char cur = x.charAt(i);
            if (Character.isUpperCase(cur)) {
                sb.append(Character.toLowerCase(cur));
            } else {
                sb.append(Character.toUpperCase(cur));
            }
        }
        System.out.println(sb);
    }
}
