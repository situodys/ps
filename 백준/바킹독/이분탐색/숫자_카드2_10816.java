package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자_카드2_10816 {
    public static int n, k;
    public static int[] numbers,targets;
    public static Map<Integer,Integer> mp;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int cur;
        mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cur = Integer.parseInt(st.nextToken());
            mp.put(cur, mp.getOrDefault(cur, 0) + 1);
        }

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            cur= Integer.parseInt(st.nextToken());
            sb.append(mp.getOrDefault(cur, 0) + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
