package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리_1068 {


    public static int n, r, q;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static List<Integer>[] edges;
    public static int parents[];
    public static int cnt = 0;
    public static int root;
    public static boolean visited[];

    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        parents = new int[n];
        edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        root=-1;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            parents[i]= cur;
            if (cur == -1) {
                root=i;
            }
        }
        int target = Integer.parseInt(br.readLine());
        parents[target]=-1;

        for (int i = 0; i < n; i++) {
            if(parents[i]==-1) continue;
            edges[i].add(parents[i]);
            edges[parents[i]].add(i);
        }

        visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        visited[root]=true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            boolean isLeaf=true;
            for (Integer nxt : edges[cur]) {
                if(visited[nxt]) continue;
                q.offer(nxt);
                visited[nxt]=true;
                isLeaf=false;
            }
            if(isLeaf)answer++;
        }

        if (target == root) {
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }
}
