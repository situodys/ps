package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리와_쿼리_15681 {

    public static int n, r, q;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static List<Integer>[] edges;
    public static int[] parents;
    public static int[] size;

    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        edges = new List[n + 1];
        parents = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <=n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
        }

        size[r]= makeTree(r,-1);

        for (int i = 0; i < q; i++) {
            int node = Integer.parseInt(br.readLine());
            sb.append(size[node]).append('\n');
        }
        System.out.println(sb);

    }

    private static int makeTree(int cur,int prev) {
        if (edges[cur].size() == 1 && edges[cur].get(0) == prev) {
            size[cur]=1;
            return 1;
        }
        int cnt=1;
        for (int nxt : edges[cur]) {
            if(nxt == prev) continue;
            cnt += makeTree(nxt, cur);
        }
        size[cur]=cnt;
        return cnt;
    }
}
