package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시_15683 {
    public static char[][] board;
    public static int[][] visited;
    public static int[] dy={-1,0,1,0};
    public static int[] dx={0,-1,0,1};
    public static int n,m;
    public static int answer=65;
    public static List<CCTV> cctvs = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][];
        visited = new int[n][];

        for(int i=0;i<n;i++){
            board[i] = new char[m];
            visited[i]= new int[m];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = st.nextToken().charAt(0);
                if(board[i][j]=='6'){
                    visited[i][j]=6;
                    continue;
                }
                if (board[i][j] != '0') {
                    cctvs.add(new CCTV(i, j, board[i][j] - '0'));
                    visited[i][j]=board[i][j]-'0';
                }
            }
        }

        dfs(0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx){
        if (idx == cctvs.size()) {
            answer = Math.min(answer, countSagak());
            return;
        }

        CCTV cur = cctvs.get(idx);
        int[][] copyArr = new int[n][];
        copy2DArr(visited, copyArr);
        for(int i=0;i<cur.loopCnt;i++){

            cur.checkSight(-1,i);
            dfs(idx+1);
            copy2DArr(copyArr,visited);
        }
    }

    private static void copy2DArr(int[][] src, int[][] dst) {
        for(int i=0;i<n;i++){
            dst[i]=new int[m];
            for(int j=0;j<m;j++){
                dst[i][j]=src[i][j];
            }
        }
    }

    private static int countSagak() {
        int sagak=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0)
                    sagak++;
            }
        }
        return sagak;
    }

    public static class CCTV{
        private int y;
        private int x;
        private int type;
        private int loopCnt;

        public CCTV(int y, int x, int type) {
            this.y=y;
            this.x=x;
            this.type=type;
            setLoopCnt();
        }

        private void setLoopCnt() {
            if (this.type == 1) {
                this.loopCnt=4;
            }
            if (this.type == 2) {
                this.loopCnt=2;
            }
            if (this.type == 3) {
                this.loopCnt=4;
            }
            if (this.type == 4) {
                this.loopCnt=4;
            }
            if (this.type == 5) {
                this.loopCnt = 1;
            }
        }

        private void checkSight(int val, int dir) {
            if (this.type == 1) {
                check(val,dir);
                return;
            }
            if(this.type==2){
                check(val,dir);
                check(val,dir+2);
                return;
            }
            if(this.type==3){
                check(val,dir);
                check(val,(dir+1)%4);
                return;
            }
            if(this.type==4){
                check(val,dir);
                check(val,(dir+1)%4);
                check(val,(dir+2)%4);
                return;
            }
            if(this.type==5){
                check(val,dir);
                check(val,dir+1);
                check(val,dir+2);
                check(val,dir+3);
            }
        }

        private void check(int val,int dir ){
            int ny=this.y;
            int nx=this.x;
            do {
                ny += dy[dir];
                nx += dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    break;
                }
                if (board[ny][nx] == '6') {
                    break;
                }
                if (board[ny][nx] != '0') {
                    continue;
                }
                if (visited[ny][nx] == val) {
                    continue;
                }
                visited[ny][nx] = val;
            } while (true);
        }
    }
}
