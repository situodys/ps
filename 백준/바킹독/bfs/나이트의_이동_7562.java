package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의_이동_7562 {

    public static int n, m, r;
    public static int dy[] = {-1,-2,-2,-1,1,2,2,1};
    public static int dx[] = {-2,-1,1,2,2,1,-1,-2};
    public static int[][] visited;
    public static int[][] board;
    public static int answer;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            visited = new int[n][n];
            st = new StringTokenizer(br.readLine());
            int stY = Integer.parseInt(st.nextToken());
            int stX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int edY = Integer.parseInt(st.nextToken());
            int edX = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{stY, stX});
            visited[stY][stX]=1;
            boolean isEnd=false;

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for(int dir=0; dir<8;dir++){
                    int ny = cur[0] + dy[dir];
                    int nx = cur[1] + dx[dir];

                    if(ny<0 || ny>=n || nx<0 ||nx>=n) continue;
                    if(visited[ny][nx] != 0) continue;
                    if (ny == edY && nx == edX) {
                        sb.append(visited[cur[0]][cur[1]]).append('\n');
                        isEnd=true;
                        break;
                    }
                    visited[ny][nx]=visited[cur[0]][cur[1]]+1;
                    q.offer(new int[]{ny, nx});
                }
                if(isEnd)break;
            }
            if (!isEnd) {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
}
