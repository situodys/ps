package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_정사각형_1051_시뮬 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{ -1, 1,0, 0};
    public static int n,m,t;
    public static int[][] board;
    public static int[][] visited;
    public static int answer=1;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for(int i=0; i<n;i++){
            String row = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = row.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                solve(i, j);
            }
        }

        System.out.println(answer);
    }

    public static void solve(int y, int x) {
        int len=0;
        int cur=board[y][x];
        while(true){
            len++;
            if(y+len >=n || x+len >=m) break;
            if(cur!=board[y+len][x]) continue;
            if(cur!=board[y][x+len]) continue;
            if(cur!=board[y+len][x+len]) continue;
            answer = Math.max((len+1)*(len+1), answer);
        }
    }
}
