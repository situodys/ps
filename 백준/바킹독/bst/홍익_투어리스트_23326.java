package ps.백준.바킹독.bst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 홍익_투어리스트_23326 {
    public static int n, m;
    public static int[] arr;
    //    public static TreeMap<Integer,Integer> sights = new TreeMap<>();
    public static TreeSet<Integer> sights = new TreeSet<>();
    public static int sightsCnt = 0;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer = 1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int cur = 0;

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int isSight = Integer.parseInt(st.nextToken());
            if (isSight == 1) {
                sights.add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if (order == 3) {
                if (sights.isEmpty()) {
                    sb.append(-1).append('\n');
                    continue;
                }
                Integer upper = sights.ceiling(cur);
                if (upper == null) {
                    sb.append(n - cur + sights.first()).append('\n');
                } else {
                    sb.append(upper - cur).append('\n');
                }
            } else if (order == 2) {
                cur = (cur + Integer.parseInt(st.nextToken())) % n;
            } else if (order == 1) {
                int sight = Integer.parseInt(st.nextToken()) - 1;
                if (sights.contains(sight)) {
                    sights.remove(sight);
                } else {
                    sights.add(sight);
                }
            }
        }
        System.out.println(sb);
    }
}
