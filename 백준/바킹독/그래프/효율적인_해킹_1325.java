package ps.백준.바킹독.그래프;

import java.util.*;
import java.io.*;

public class 효율적인_해킹_1325 {

    public static int n, m, start;
    public static List<List<Integer>> board;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static boolean visited[];
    private static long maxScore = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new ArrayList<>();
        int[] cnts = new int[n];

        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
        }

        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            board.get(to).add(from);
        }

        for (int i = 0; i < n; i++) {
            cnts[i] = bfs(i);
            maxScore = Math.max(cnts[i], maxScore);
        }

        for (int i = 0; i < n; i++) {
            if (cnts[i] == maxScore) {
                sb.append(i + 1).append(' ');
            }
        }
        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n];
        q.offer(start);
        visited[start]=true;
        int cnt=1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer nxt : board.get(cur)) {
                if(visited[nxt])continue;
                q.offer(nxt);
                visited[nxt]=true;
                cnt++;
            }
        }
        return cnt;
    }
}
