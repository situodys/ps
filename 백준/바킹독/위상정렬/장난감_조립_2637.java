package ps.백준.바킹독.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 장난감_조립_2637 {


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
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        indegree = new int[n + 1];
        edges = new List[n + 1];
        boolean[] isMiddle = new boolean[n + 1];
        int[] basic = new int[n + 1];
        int[][] needCnt = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int midProduct = Integer.parseInt(st.nextToken());
            int basicProduct = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            indegree[basicProduct]++;
            edges[midProduct].add(basicProduct);
            needCnt[midProduct][basicProduct] = cnt;
            isMiddle[midProduct]=true;
        }

        List<Integer> basics = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            if (!isMiddle[i]) {
                basics.add(i);
            }
        }

        Queue<Integer> q =new LinkedList<>();
        q.offer(n);
        basic[n]=1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer nxt : edges[cur]) {
                indegree[nxt]--;
                basic[nxt] += basic[cur] * needCnt[cur][nxt];
                if (indegree[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }

        for (Integer no : basics) {
            System.out.println(no+" "+ basic[no]);
        }
    }
}
