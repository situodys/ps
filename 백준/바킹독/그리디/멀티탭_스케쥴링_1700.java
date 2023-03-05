package ps.백준.바킹독.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 멀티탭_스케쥴링_1700 {

    public static int n, k;
    public static int[] orders;
    public static List<Integer> multiTap;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        multiTap = new ArrayList<>();
        orders = new int[k];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            int cur = orders[i];
            if (multiTap.contains(cur)) {
                continue;
            }
            if (multiTap.size() == n) {
                List<int[]> remainOrders = new ArrayList<>();
                calculateDeleteOrder(i, remainOrders);

                if (remainOrders.isEmpty()) {
                    multiTap.remove(0);
                    answer++;
                    multiTap.add(cur);
                    continue;
                }

                remainOrders.sort((int[] a, int[] b) -> b[1] - a[1]);
                Integer deletedValue = remainOrders.get(0)[0];
                multiTap.remove(deletedValue);
                answer++;
            }
            multiTap.add(cur);
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    public static void calculateDeleteOrder(int idx, List<int[]> remainOrders) {
        boolean[] isCheck = new boolean[101];

        for(int j = 0; j<multiTap.size(); j++){
            int cur = multiTap.get(j);
            for (int i = idx+1; i < k; i++) {
                if (cur == orders[i] && !isCheck[cur]) {
                    isCheck[cur]=true;
                    remainOrders.add(new int[]{cur,i});
                }
            }
            if (!isCheck[multiTap.get(j)]) {
                remainOrders.add(new int[]{multiTap.get(j), k + 1});
            }
        }
    }
}
