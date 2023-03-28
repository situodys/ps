package ps.백준.바킹독.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결_요소의_개수_11724 {

    public static int n, m;
    public static List<List<Integer>> board;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int visited[];
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new ArrayList<>();
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            board.get(a).add(b);
            board.get(b).add(a);
        }

        /*
        bfs or dfs
         */

        System.out.println(vis);
    }

    //BFS
    /*
    int vis=0;
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            visited[i]=vis++;
            q.offer(i);

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (Integer nxt : board.get(cur)) {
                    if(visited[nxt]!=0) continue;
                    q.offer(nxt);
                    visited[nxt]=vis;
                }
            }
        }
     */

    //DFS
    /*
    int vis = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) {
                continue;
            }
            vis++;
            Stack<Integer> stack = new Stack<>();
            stack.push(i);

            while (!stack.isEmpty()) {
                int cur = stack.pop();
                if (visited[cur] != 0) {
                    continue;
                }
                visited[cur] = vis;
                for (Integer nxt : board.get(cur)) {
                    if (visited[nxt] != 0) {
                        continue;
                    }
                    stack.push(nxt);
                }
            }
        }
     */
}
