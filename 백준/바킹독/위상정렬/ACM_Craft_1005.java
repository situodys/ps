package ps.백준.바킹독.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft_1005 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[] indegree;
    public static List<Integer>[] edges;
    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;
    private static int idx = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            answer=0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int delays[] = new int[n + 1];
            indegree = new int[n + 1];
            int[] sumOfDelays = new int[n + 1];
            edges = new List[n + 1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n;i++){
                delays[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<=n;i++){
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                edges[from].add(to);
                indegree[to]++;
            }
            int target = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=n;i++){
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (Integer nxt : edges[cur]) {
                    indegree[nxt]--;
                    sumOfDelays[nxt] = Math.max(sumOfDelays[nxt], delays[cur] + sumOfDelays[cur]);
                    if (indegree[nxt] == 0) {
                        q.offer(nxt);
                    }
                }
            }
            System.out.println(delays[target]+sumOfDelays[target]);
        }
    }
}
