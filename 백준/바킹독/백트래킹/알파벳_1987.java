package ps.백준.바킹독.백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 알파벳_1987 {
    public static int n, m;
    public static int answer;
    public static char[][] board;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        String history = String.valueOf(board[0][0]);

        dfs(0,0,history);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void dfs(int y, int x, String sb) {

        answer = Math.max(answer, sb.length());

        String prev=sb;

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx= x + dx[dir];

            if(ny<0 || ny>=n || nx<0 |nx>=m) continue;
            if(sb.contains(String.valueOf(board[ny][nx])))continue;
            dfs(ny, nx, sb + board[ny][nx]);
            sb=prev;
        }
    }
}
