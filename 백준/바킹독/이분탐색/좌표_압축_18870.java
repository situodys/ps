package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 좌표_압축_18870 {

    public static int n, k;
    public static int[] numbers;
    public static Set<Integer> set = new HashSet<>();
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        numbers = new int[n];

        st = new StringTokenizer(br.readLine());

        int cur;
        for (int i = 0; i < n; i++) {
            cur = Integer.parseInt(st.nextToken());
            numbers[i] = cur;
            set.add(cur);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            mp.put(list.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(mp.get(numbers[i]) + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
