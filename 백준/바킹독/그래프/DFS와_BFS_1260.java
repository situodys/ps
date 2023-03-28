package ps.백준.바킹독.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS와_BFS_1260 {

    public static int n, m, start;
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
        start = Integer.parseInt(st.nextToken());

        board = new ArrayList<>();
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            board.get(a).add(b);
            board.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(board.get(i));
        }

        int vis = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(start-1);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (visited[cur] != 0) {
                continue;
            }
            visited[cur] = vis;
            sb.append(cur + 1).append(' ');
            for (int i=board.get(cur).size()-1; i>=0; i--) {
                if (visited[board.get(cur).get(i)] != 0) {
                    continue;
                }
                stack.push(board.get(cur).get(i));
            }
        }

        sb.append('\n');
        vis = 1;
        visited = new int[n];
        Queue<Integer> q = new LinkedList<>();
        visited[start-1] = vis;
        q.offer(start-1);
        sb.append(start).append(' ');

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer nxt : board.get(cur)) {
                if (visited[nxt] != 0) {
                    continue;
                }
                q.offer(nxt);
                visited[nxt] = vis;
                sb.append(nxt + 1).append(' ');
            }
        }
        System.out.println(sb);
    }
}
