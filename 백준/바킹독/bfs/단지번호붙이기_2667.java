package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 단지번호붙이기_2667 {
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{ 0,-1, 0, 1};
    public static int n, m, t;
    public static int[][] board;
    public static boolean[][]visited;
    public static List<Integer> cnts = new ArrayList<>();
    public static int answer;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n;i++){
            String row = br.readLine();
            for(int j=0; j<n;j++){
                board[i][j] = row.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int count=0;

        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                if(visited[i][j]|| board[i][j]==0) continue;
                visited[i][j]=true;
                q.offer(new int[]{i, j});
                int areaCnt=1;
                count++;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for(int dir=0;dir<4;dir++){
                        int ny = cur[0] + dy[dir];
                        int nx = cur[1] + dx[dir];

                        if(ny<0 || ny>=n || nx<0 ||nx>=n) continue;
                        if(visited[ny][nx] || board[ny][nx]==0) continue;
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx]=true;
                        areaCnt++;
                    }
                }

                cnts.add(areaCnt);
            }
        }
        System.out.println(count);
        cnts.sort(Comparator.naturalOrder());

        for (Integer a : cnts) {
            System.out.println(a);
        }
    }
}
