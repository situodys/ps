package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maaaaaaaaaze_16985 {
    public static int[][][] board = new int[5][5][5];
    public static int[][][] origin = new int[5][5][5];
    public static int[][][] visited;
    public static int[] order = new int[5];
    public static boolean[] orderFlag = new boolean[5];

    public static int[] dy = {0,0,-1, 0, 1, 0};
    public static int[] dx = {0,0,0, 1, 0, -1};
    public static int[] dz = {-1, 1,0,0,0,0};
    public static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<5;i++){
            for(int j=0 ;j<5;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<5;k++){
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        solve();
        System.out.println(answer==Integer.MAX_VALUE?-1:answer-1);
    }

    public static void solve() {
        for(int i=0; i<(1<<10)-1; i++){
            int tmp =i;
            copyArr(board, origin);
            for(int j=0 ; j<5; j++){
                rotate(j, tmp % 4);
                tmp /= 4;
            }
            doOrder(0,0);
            copyArr(origin,board);
        }
    }

    private static void copyArr(int[][][] src, int[][][] dst) {
        for(int i=0 ;i<5;i++){
            for(int j=0 ;j<5;j++){
                for(int k=0;k<5;k++){
                    dst[i][j][k]=board[i][j][k];
                }
            }
        }
    }

    private static void doOrder(int idx,int cnt) {
        if(cnt ==5){
            int[][][]tmp = new int[5][5][5];

            for(int i=0 ;i<5;i++){
                tmp[i] = board[order[i]];
            }
            bfs(tmp);
            return;
        }

        for(int i=0;i<5;i++){
            if(orderFlag[i]) continue;
            order[idx]=i;
            orderFlag[i]=true;
            doOrder(idx+1,cnt + 1);
            orderFlag[i]=false;
        }
    }

    public static void rotate(int layer,int cnt) {
        int[][] tmp = new int[5][5];

        if(cnt==0) return;

        else if (cnt == 1) {
            for(int i=0 ;i<5;i++){
                for(int j=0; j<5;j++){
                    tmp[i][j]=board[layer][5-j-1][i];
                }
            }
        }
        else if (cnt == 2) {
            for(int i=0 ;i<5;i++){
                for(int j=0; j<5;j++){
                    tmp[i][j]=board[layer][5-i-1][5-j-1];
                }
            }
        }
        else{
            for(int i=0 ;i<5;i++){
                for(int j=0; j<5;j++){
                    tmp[i][j]=board[layer][j][5-i-1];
                }
            }
        }
        board[layer] = tmp;

    }

    private static void bfs(int[][][] target) {
        if(target[0][0][0]==0) return;
        int[] startLoc = new int[]{0, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        visited = new int[5][5][5];
        visited[0][0][0]=1;
        q.offer(startLoc);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0; dir<6; dir++){
                int nz= cur[0]+dz[dir];
                int ny= cur[1]+dy[dir];
                int nx= cur[2]+dx[dir];
                if(nz<0 || nz>=5 ||ny<0 ||ny>=5 || nx<0 ||nx>=5) continue;
                if(target[nz][ny][nx]==0 || visited[nz][ny][nx] !=0) continue;
                if (nz == 4 && ny == 4 && nx == 4) {
                    answer = Math.min(answer, visited[cur[0]][cur[1]][cur[2]] + 1);
                    return;
                }
                q.offer(new int[]{nz, ny, nx});
                visited[nz][ny][nx] = visited[cur[0]][cur[1]][cur[2]]+1;
            }
        }

    }
}
