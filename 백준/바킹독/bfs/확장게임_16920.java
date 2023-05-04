package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 확장게임_16920 {

    public static int n, m, p;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static boolean[][] visited;
    public static char[][] board;
    public static int[] moveAmount;
    public static Queue<int[]> q;
    public static int answer = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];
        moveAmount = new int[p + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= p; i++) {
            moveAmount[i] = Integer.parseInt(st.nextToken());
        }

        //번호,번쨰,y,x

        List<int[]> cands = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == '.' || board[i][j] == '#')
                    continue;
                cands.add(new int[]{board[i][j] - '0', i, j});
                visited[i][j] = true;
            }
        }

        cands.sort(Comparator.comparingInt((int[] a) -> a[0]));
        q = new LinkedList<>(cands);

        while (!q.isEmpty()) {
            fillMap();
        }

        int[] answers = new int[p + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#' || board[i][j] == '.')
                    continue;
                answers[board[i][j] - '0']++;
            }
        }
        for (int i = 1; i <= p; i++) {
            sb.append(answers[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void fillMap() {
        Queue<int[]> inner = new LinkedList<>();
        int[] std = q.poll();
        int curNo= std[0];
        char curChar = Character.forDigit(curNo, 10);
        inner.offer(new int[]{0, std[1], std[2]});

        while (!q.isEmpty()) {
            if(q.peek()[0]!=std[0]) break;
            int[] cur = q.poll();
            inner.offer(new int[]{0, cur[1], cur[2]});
        }

        while (!inner.isEmpty()) {
            int[] cur = inner.poll();
            int len = cur[0];
            int y = cur[1];
            int x = cur[2];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if(ny<0 ||ny>=n || nx<0 || nx>=m) continue;
                if(len >= moveAmount[curNo]) continue;
                if(visited[ny][nx]) continue;
                if(board[ny][nx]=='#') continue;
                board[ny][nx] = curChar;
                visited[ny][nx]= true;
                q.offer(new int[]{curNo, ny, nx});
                inner.offer(new int[]{len + 1, ny, nx});
            }
        }
    }
}
