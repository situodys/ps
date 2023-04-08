package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리의_높이와_너비_2250 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static boolean isNotRoot[];
    public static int left[];
    public static int right[];
    public static Map<Integer, MinMax> map;
    public static List<Integer>[] edges;

    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;
    private static int idx=0;

    //12:59~13:59
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        left = new int[n + 1];
        right = new int[n + 1];
        isNotRoot = new boolean[n + 1];
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int rt = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (l != -1) {
                isNotRoot[l]=true;
            }
            if (r != -1) {
                isNotRoot[r]=true;
            }

            left[rt]=l;
            right[rt]=r;

            map.put(i + 1, new MinMax());
        }
        int root=-1;
        for (int i = 1; i <=n; i++) {
            if (!isNotRoot[i]) {
                root=i;
                break;
            }
        }

        inOrder(root, 1,0);

        for (int i = 1; i <= n; i++) {
            MinMax minMax = map.get(i);
            int width = minMax.max - minMax.min + 1;
            if (answer < width) {
                answer = width;
                idx= i;
            }
        }
        System.out.println(idx+" "+ answer);

    }

    private static int inOrder(int start, int layer, int leftCnt) {
        if (left[start] == -1 && right[start] == -1) {
            int cur = leftCnt+1;
            map.get(layer).min = Math.min(cur, map.get(layer).min);
            map.get(layer).max = Math.max(cur, map.get(layer).max);
            return cur;
        }
        int children=0;
        int leftChildren=leftCnt;
        if (left[start] != -1) {
            leftChildren = inOrder(left[start],layer+1,leftCnt);
        }

        leftChildren+=1;
        map.get(layer).min = Math.min(leftChildren, map.get(layer).min);
        map.get(layer).max = Math.max(leftChildren, map.get(layer).max);

        if (right[start] != -1) {
            children = inOrder(right[start],layer+1,leftChildren);
        }
        return Math.max(children,leftChildren);
    }

    private static class MinMax {
        int max;
        int min;

        public MinMax() {
            this.max = -1;
            this.min = 10010;
        }
    }
}
