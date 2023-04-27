package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {
    public static int n, m, r;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[] visited;
    public static int[] board;
    public static int answer;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[100011];

        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        q.offer(n);

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            if (cur == m) {
                System.out.println(visited[m]-1);
                return;
            }

            if (cur - 1 >= 0 && visited[cur-1]==0) {
                q.offer(cur-1);
                visited[cur-1] = visited[cur]+1;
            }
            if (cur + 1 <= 100000 && visited[cur+1]==0) {
                q.offer(cur+1);
                visited[cur+1] = visited[cur]+1;
            }
            if (cur*2 <= 100000 && visited[cur*2]==0) {
                q.offer(cur*2);
                visited[cur*2] = visited[cur]+1;
            }
        }

    }
}
