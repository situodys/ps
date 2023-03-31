package ps.백준.바킹독.그래프;

import java.util.*;
import java.io.*;

public class 구슬_찾기_2617 {
    public static int n, m, start;
    public static List<List<Integer>> heavyBoard = new ArrayList<>();
    public static List<List<Integer>> lightBoard = new ArrayList<>();
    public static int[] heavyCnt;
    public static int[] lightCnt;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static boolean visited[];
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        heavyCnt = new int[n];
        lightCnt = new int[n];

        for (int i = 0; i < n; i++) {
            heavyBoard.add(new ArrayList<>());
            lightBoard.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken()) - 1;
            int light = Integer.parseInt(st.nextToken()) - 1;

            heavyBoard.get(light).add(heavy);
            lightBoard.get(heavy).add(light);
        }

        for (int i = 0; i < n; i++) {
            if (heavyCnt[i] == 0) {
                bfs(heavyBoard, heavyCnt, i);
            }
            bfs(lightBoard, lightCnt, i);
        }

        int mid = (n+1)/2;
        for (int i = 0; i < n; i++) {
            if (heavyCnt[i] >= mid) {
                answer++;
            }
            if (lightCnt[i] >= mid) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void bfs(List<List<Integer>> board, int[] cnt, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited = new boolean[n];

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer nxt : board.get(cur)) {
                if (visited[nxt]) {
                    continue;
                }
                visited[nxt]=true;
                cnt[start]++;
                q.offer(nxt);
            }
        }
    }
}
