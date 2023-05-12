package ps.백준.바킹독.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고스팟_1261 {

    public static int n, m, start, v1, v2;
    public static int dy[] = {0, 0, -1, 1, 0, 0};
    public static int dx[] = {1, -1, 0, 0, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[] dist;
    public static List<int[]>[] edges;
    public static int[][] board;
    public static int[][] brokenWalls;
    public static boolean[][] visited;
    public static int answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        edges = new List[n + 1];
        board = new int[n][m];
        brokenWalls = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(brokenWalls[i], MAX_VAlUE);
        }

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));

        pq.offer(new int[]{0, 0, 0});
        brokenWalls[0][0] = 0;
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int brokenWallCount = cur[0];
            int y = cur[1];
            int x = cur[2];

            if(brokenWallCount > brokenWalls[y][x]) continue;

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }
                if (board[ny][nx] == 1) {
                    if (brokenWallCount+1 >= brokenWalls[ny][nx]) {
                        continue;
                    }
                    brokenWalls[ny][nx]=brokenWallCount+1;
                    pq.offer(new int[]{brokenWallCount + 1, ny, nx});
                }
                else{
                    if (brokenWallCount >= brokenWalls[ny][nx]) {
                        continue;
                    }
                    brokenWalls[ny][nx]=brokenWallCount;
                    pq.offer(new int[]{brokenWallCount, ny, nx});
                }
            }
        }
        System.out.println(brokenWalls[n-1][m-1]);
    }
}
