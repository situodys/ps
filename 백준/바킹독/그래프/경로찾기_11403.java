package ps.백준.바킹독.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로찾기_11403 {

    public static int n, m, start;
    public static int[][] board;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static boolean visited[];
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(bfs(i,j)).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int bfs(int from, int to) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n];
        q.offer(from);
        visited[from]=true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < n; i++) {
                if (board[cur][i] == 1 && i==to) {
                    return 1;
                }
                if(board[cur][i]==0) continue;
                if(visited[i]) continue;

                q.offer(i);
                visited[i]=true;
            }
        }
        return 0;
    }
}
