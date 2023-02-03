package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {
    //2:33~
    public static int n,m;
    public static char[][] board;
    public static boolean[][] visited;
    public static Queue<int[]> virusLocation = new LinkedList<>();
    public static int answer =0;
    public static int initSafeZoneCount=0;
    public static int newVirusCount=0;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n;i++){
            st =new StringTokenizer(br.readLine()) ;
            for(int j=0; j<m;j++){
                board[i][j] =st.nextToken().charAt(0);
                if (board[i][j] == '2') {
                    virusLocation.offer(new int[]{i, j});
                }
                if (board[i][j] == '0') {
                    initSafeZoneCount++;
                }
            }
        }
        dfs(0);
        bw.write(""+answer);
        bw.flush();
    }

    public static void dfs(int wallCount) {
        if (wallCount == 3) {
            visited = new boolean[n][m];
            newVirusCount=0;
            spreadVirus();
            calculateSafeZone();
            return;
        }

        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(board[i][j] != '0') continue;
                board[i][j] ='1';
                dfs(wallCount+1);
                board[i][j]='0';
            }
        }
    }

    private static void calculateSafeZone() {
        answer = Math.max(answer, initSafeZoneCount-newVirusCount-3);
    }

    private static void spreadVirus() {
        Queue<int[]> viruses = new LinkedList<>(virusLocation);
        while (!viruses.isEmpty()) {
            int[] virus = viruses.poll();
            for(int dir=0; dir<4; dir++){
                int ny = virus[0] + dy[dir];
                int nx = virus[1] + dx[dir];
                if(ny<0 ||ny>=n ||nx<0 ||nx>=m) continue;
                if(visited[ny][nx] || board[ny][nx] != '0') continue;
                visited[ny][nx]=true;
                viruses.offer(new int[]{ny, nx});
                newVirusCount++;
            }
        }
    }
}
