package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한_줄로_서기_1138 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int n, m, t;

    public static int answer;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] orders = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (cnt >= cur && orders[j] == 0) {
                    orders[j] = i;
                    break;
                }
                if(orders[j]==0)
                    cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : orders) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
