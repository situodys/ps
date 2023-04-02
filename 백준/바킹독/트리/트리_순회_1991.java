package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리_순회_1991 {
    public static int n, k, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[] left;
    public static int[] right;
    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        left = new int[30];
        right = new int[30];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String cur = st.nextToken();
            String l = st.nextToken();
            String r = st.nextToken();
            int curIdx = cur.charAt(0)-'A'+1;
            if (!l.equals(".")) {
                left[curIdx]= l.charAt(0)-'A'+1;
            }
            if (!r.equals(".")) {
                right[curIdx]= r.charAt(0)-'A'+1;
            }
        }

        preOrder(1);
        sb.append('\n');
        inOrder(1);
        sb.append('\n');
        postOrder(1);

        System.out.println(sb);

    }

    private static void preOrder(int cur) {
        sb.append((char) (cur + 'A' - 1));
        if(left[cur] !=0) preOrder(left[cur]);
        if(right[cur] !=0) preOrder(right[cur]);
    }

    private static void inOrder(int cur) {
        if(left[cur] !=0) inOrder(left[cur]);
        sb.append((char) (cur + 'A' - 1));
        if(right[cur] !=0) inOrder(right[cur]);
    }

    private static void postOrder(int cur) {
        if(left[cur] !=0) postOrder(left[cur]);
        if(right[cur] !=0) postOrder(right[cur]);
        sb.append((char) (cur + 'A' - 1));
    }
}
