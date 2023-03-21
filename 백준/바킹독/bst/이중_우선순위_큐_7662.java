package ps.백준.바킹독.bst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 이중_우선순위_큐_7662 {

    public static int n, m;
    public static int[] arr, dup;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer = 1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        while (n-- > 0) {
            m = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int cur = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    if (cur == -1) {
                        Integer key = map.firstKey();
                        if (map.get(key) == 1) {
                            map.remove(key);
                        } else {
                            map.put(key, map.get(key) - 1);
                        }
                    } else {
                        Integer key = map.lastKey();
                        if (map.get(key) == 1) {
                            map.remove(key);
                        } else {
                            map.put(key, map.get(key) - 1);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                bw.write("EMPTY");
            } else {
                bw.write("" + map.lastKey() + " " + map.firstKey());
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
