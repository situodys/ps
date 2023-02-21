package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색맹_10026 {

    public static int n;
    public static int normalAnswer,blindAnswer = 0;
    public static char board[][];
    public static boolean visited[][];
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            board[i] = row.toCharArray();
        }

        normalAnswer = countArea();

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    board[i][j] = 'G';
                }
            }
        }

        blindAnswer = countArea();

        bw.write("" + normalAnswer + " " + blindAnswer);
        bw.flush();
        bw.close();
    }

    private static int countArea() {
        Queue<int[]> q = new LinkedList<>();
        int areaCount=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]) continue;

                areaCount++;
                char target= board[i][j];
                q.offer(new int[]{i, j});
                visited[i][j]=true;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int ny= cur[0]+dy[dir];
                        int nx = cur[1] + dx[dir];

                        if(ny<0 || ny>=n || nx<0 ||nx>=n) continue;
                        if(visited[ny][nx] || board[ny][nx] != target) continue;
                        visited[ny][nx]= true;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        return areaCount;
    }
}
