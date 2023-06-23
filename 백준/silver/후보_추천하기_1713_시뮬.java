package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 후보_추천하기_1713_시뮬 {
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

        n = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> photos = new HashMap<>();
        Map<Integer, Integer> orders = new HashMap<>();

        for (int i = 0; i < t; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (photos.containsKey(cur)) {
                photos.put(cur, photos.get(cur) + 1);
                continue;
            }
            if (photos.size() == n) {
                int leastUp = 10001;
                int leastIdx = -1;
                for (Integer key : photos.keySet()) {
                    if (leastUp == photos.get(key)) {
                        if (orders.get(leastIdx) > orders.get(key)) {
                            leastIdx = key;
                            continue;
                        }
                    }

                    if (leastUp > photos.get(key)) {
                        leastUp = photos.get(key);
                        leastIdx = key;
                        continue;
                    }
                }
                photos.remove(leastIdx);
                orders.remove(leastIdx);

                photos.put(cur, 1);
                orders.put(cur, i);
                continue;
            }
            orders.put(cur, i);
            photos.put(cur, 1);
        }

        ArrayList<Integer> ans = new ArrayList<>(photos.keySet());
        ans.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();

        for (Integer a : ans) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
