package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어_뒤집기2 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{ -1, 1,0, 0};
    public static int n,m,t;
    public static int[][] board;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String x = br.readLine();
        st = new StringTokenizer(x, " <>", true);
        StringBuilder sb = new StringBuilder();
        boolean isInTag = false;
        while (st.hasMoreTokens()) {
            String cur = st.nextToken();
            if (cur.equals("<") || cur.equals(">")) {
                sb.append(cur);
                isInTag = !isInTag;
                continue;
            }
            if (isInTag) {
                sb.append(cur);
                continue;
            }
            else{
                sb.append(new StringBuilder(cur).reverse());
            }
        }
        System.out.println(sb);
    }
}
