package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무_재테크_16235 {

    public static int n, m, k;
    public static int dy[] = {0, 0, -1, 1, 1, 1, -1, -1};
    public static int dx[] = {1, -1, 0, 0, 1, -1, 1, -1};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[][] feeds;
    public static int[][] increaseAmount;
    public static boolean[][] visited;
    public static PriorityQueue<int[]> pq;
    public static Queue<int[]> deadTrees;
    public static int[] sums;
    public static long answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        feeds = new int[n][n];
        increaseAmount = new int[n][n];
        pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[2]));
        deadTrees = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                increaseAmount[i][j] = Integer.parseInt(st.nextToken());
                feeds[i][j] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{y, x, age});
        }

        while (k-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(pq.size());

    }

    private static void spring() {
        List<int[]> tmp = new ArrayList<>(pq);
        pq.clear();
        int len = tmp.size();
        if (len == 0) {
            return;
        }
        for (int i = 0; i < len; i++) {
            int[] cur = tmp.get(i);
            int y = cur[0];
            int x = cur[1];
            int age = cur[2];
            if (age > feeds[y][x]) {
                deadTrees.offer(cur);
                continue;
            }

            feeds[y][x] -= age;
            pq.offer(new int[]{y, x, age + 1});
        }
    }

    private static void summer() {
        while (!deadTrees.isEmpty()) {
            int[] cur = deadTrees.poll();
            feeds[cur[0]][cur[1]] += cur[2] / 2;
        }
    }

    private static void fall() {
        List<int[]> tmp = new ArrayList<>(pq);
        for (int[] tree : tmp) {
            if (tree[2] % 5 != 0) {
                continue;
            }
            for (int dir = 0; dir < 8; dir++) {
                int ny = tree[0] + dy[dir];
                int nx = tree[1] + dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                    continue;
                }
                pq.offer(new int[]{ny, nx, 1});
            }
        }
    }

    private static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                feeds[i][j] += increaseAmount[i][j];
            }
        }
    }
}
