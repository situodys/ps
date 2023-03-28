package ps.백준.바킹독.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스_2606 {

    public static int n, m, start;
    public static List<List<Integer>> board;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static boolean visited[];
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        board = new ArrayList<>();
        visited = new boolean[n];

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

        Queue<Integer> q = new LinkedList<>();
        visited[0]=true;
        q.offer(0);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer nxt : board.get(cur)) {
                if(visited[nxt])continue;
                q.offer(nxt);
                answer++;
                visited[nxt]=true;
            }
        }

        System.out.println(answer);
    }
}
