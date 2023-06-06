package ps.백준.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2636_bfs {

    //절대 따라하면 안되는 풀이,,

    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{ -1, 1,0, 0};
    public static int n,m;
    public static int[][] board;
    public static int[][] emptyArea;
    public static boolean[][] isAlreadyMeltChecked;
    public static Queue<int[]> emptyAreaLocs;
    public static Queue<int[]> readyToMelt;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        int cheeseCnt=0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }

        int day=0;
        while(true){
            emptyArea = new int[n][m];
            readyToMelt = new LinkedList<>();
            isAlreadyMeltChecked = new boolean[n][m];
            if (n == 1) {
                System.out.println(0);
                System.out.println(m);
            }
            if (m == 1) {
                System.out.println(0);
                System.out.println(n);
            }
            init();
            int emptyCnt = getEmptyArea();
            if (emptyCnt + readyToMelt.size() == (n-2) * (m-2)) {
                System.out.println(day+1);
                System.out.println(readyToMelt.size());
                break;
            }
            melt();
            day++;
        }
    }

    private static void init() {
        for(int i=1; i<m-1;i++){
            if (board[1][i] == 1 && !isAlreadyMeltChecked[1][i]) {
                isAlreadyMeltChecked[1][i]=true;
                readyToMelt.add(new int[]{1, i});
            }
            if (board[n-2][i] == 1 && !isAlreadyMeltChecked[n-2][i]) {
                isAlreadyMeltChecked[n-2][i]=true;
                readyToMelt.add(new int[]{n-2, i});
            }
        }
        for(int i=1; i<n-1;i++){
            if (board[i][1] == 1 && !isAlreadyMeltChecked[i][1]) {
                isAlreadyMeltChecked[i][1]=true;
                readyToMelt.add(new int[]{i, 1});
            }
            if (board[i][m-2] == 1 && !isAlreadyMeltChecked[i][m-2]) {
                isAlreadyMeltChecked[i][m-2]=true;
                readyToMelt.add(new int[]{i,m-2});
            }
        }
    }

    private static void melt() {
        while (!readyToMelt.isEmpty()) {
            int[] cur = readyToMelt.poll();
            board[cur[0]][cur[1]]=0;
        }
    }

    public static int getEmptyArea() {
        int idx=0;
        int cnt=0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if(emptyArea[i][j] != 0 || board[i][j]==1) continue;
                idx++;
                cnt++;
                Queue<int[]> q = new LinkedList<>();
                emptyAreaLocs = new LinkedList<>();
                q.offer(new int[]{i, j});
                emptyAreaLocs.offer(new int[]{i, j});
                emptyArea[i][j]=idx;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for(int dir=0;dir<4;dir++){
                        int ny=dy[dir]+cur[0];
                        int nx=dx[dir]+cur[1];
                        if(ny<1 || ny>=n-1 || nx<1 ||nx>=m-1) continue;
                        if(board[ny][nx]==1 || emptyArea[ny][nx]!=0) continue;
                        q.offer(new int[]{ny, nx});
                        emptyAreaLocs.offer(new int[]{ny, nx});
                        emptyArea[ny][nx] = emptyArea[cur[0]][cur[1]];
                        cnt++;
                    }
                }

                if (!isEmptyLocInCheese()) {
                    getMeltingCheese();
                }
            }
        }
        return cnt;
    }

    private static void getMeltingCheese() {
        boolean[][] visited= new boolean[n][m];

        while (!emptyAreaLocs.isEmpty()) {
            int cur[] = emptyAreaLocs.poll();
            for(int dir=0;dir<4;dir++){
                int ny= dy[dir]+cur[0];
                int nx= dx[dir]+cur[1];
                if(ny<1 || ny>=n-1 ||nx<1 ||nx>=m-1) continue;
                if(visited[ny][nx]) continue;
                if (board[ny][nx] == 1 && !isAlreadyMeltChecked[ny][nx]) {
                    visited[ny][nx]=true;
                    isAlreadyMeltChecked[ny][nx]=true;
                    readyToMelt.offer(new int[]{ny, nx});
                }
            }
        }
    }

    private static boolean isEmptyLocInCheese() {
        Queue<int[]> tmp = new LinkedList<>(emptyAreaLocs);
        while (!tmp.isEmpty()) {
            int[] cur = tmp.poll();
            for(int dir=0; dir<4;dir++){
                int ny= cur[0]+dy[dir];
                int nx = cur[1]+dx[dir];
                if(ny<1 || nx<1 ||ny>=n-1 || nx>=m-1) return false;
            }
        }
        return true;
    }
}
