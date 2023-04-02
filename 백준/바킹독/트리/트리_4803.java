package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 트리_4803 {
    public static int n, k, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static List<Integer>[] edges;
    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int caseCnt=0;
        while (true) {
            caseCnt++;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            edges = new List[n + 1];
            for (int i = 0; i <=n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                edges[from].add(to);
                edges[to].add(from);
            }

            int[] parents = new int[n + 1];
            int treeCnt=0;

            for (int i = 1; i <=n; i++) {
                if(parents[i] != 0) continue;
                if (isTree(i, parents)) {
                    treeCnt++;
                }
            }

            sb.append("Case ").append(caseCnt).append(": ");
            if (treeCnt == 0) {
                sb.append("No trees.\n");
            }
            if (treeCnt == 1) {
                sb.append("There is one tree.\n");
            }
            if (treeCnt > 1) {
                sb.append("A forest of ").append(treeCnt).append(" trees.\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isTree(int start, int[] parents) {
        Stack<Main.Node> stack =new Stack<>();
        stack.push(new Main.Node(start,-1));
        boolean isTree=true;

        while(!stack.isEmpty()){
            Main.Node cur = stack.pop();
            if(parents[cur.cur] !=0) continue;
            parents[cur.cur]=cur.prev;
            for(int i=edges[cur.cur].size()-1; i>=0; i--){
                Integer nxt = edges[cur.cur].get(i);
                if(cur.prev== nxt) continue;
                if(parents[nxt] != 0) {
                    isTree=false;
                    break;
                }
                stack.push(new Main.Node(nxt,cur.cur));
            }
        }
        return isTree;
    }

    private static class Node {
        int prev;
        int cur;

        public Node(int cur, int prev) {
            this.cur = cur;
            this.prev=prev;
        }
    }
}
