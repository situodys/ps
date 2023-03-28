package ps.백준.바킹독.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 결혼식_5567 {

    public static int n, m, start;
    public static List<List<Integer>> board;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int visited[];
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

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

        Queue<Integer> q = new LinkedList<>();
        visited[0]=1;
        q.offer(0);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if(visited[cur]>2) continue;
            for (Integer nxt : board.get(cur)) {
                if(visited[nxt] != 0)continue;
                q.offer(nxt);
                answer++;
                visited[nxt]=visited[cur]+1;
            }
        }

        System.out.println(answer);
    }
}
