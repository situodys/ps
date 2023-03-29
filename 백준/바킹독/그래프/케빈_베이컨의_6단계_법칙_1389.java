package ps.백준.바킹독.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈_베이컨의_6단계_법칙_1389 {

    public static int n, m, start;
    public static List<List<Integer>> board;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int visited[];
    private static long minScore = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new ArrayList<>();
        visited = new int[n];
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
        }

        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            board.get(from).add(to);
            board.get(to).add(from);
        }

        for (int i = 0; i < n; i++) {
            scores[i] = bfs(i);
            minScore = Math.min(scores[i], minScore);
        }

        for (int i = 0; i < n; i++) {
            if (scores[i] == minScore) {
                System.out.println(i+1);
                return;
            }
        }
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited = new int[n];
        q.offer(start);
        visited[start]=1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer nxt : board.get(cur)) {
                if(visited[nxt] != 0 )continue;
                q.offer(nxt);
                visited[nxt]=visited[cur]+1;
            }
        }
        int sum=0;
        for (int i = 0; i < n; i++) {
            if(i==start)continue;
            sum +=visited[i];
        }
        return sum;
    }
}
