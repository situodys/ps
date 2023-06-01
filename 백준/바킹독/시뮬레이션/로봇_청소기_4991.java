package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇_청소기_4991 {

    public static int n,m;
    public static int dy[] = {0, 0, -1, 1}; //, 1, 1, -1, -1
    public static int dx[] = {1, -1, 0, 0}; //, 1, -1, 1, -1
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int answer = 0;
    public static List<int[]> dirties;
    public static char[][] board;
    public static int[][] startToDirtiesDist;
    public static int[][][] distBetweenDirties;
    public static int[] order;
    public static boolean[] visited;

    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    //11:59
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;
            if(n==0 && m==0) break;

            board = new char[n][m];
            dirties = new ArrayList<>();
            startToDirtiesDist=new int[n][m];
            int[] start=null;

            for(int i=0; i<n;i++){
                String row = br.readLine();
                for(int j=0; j<m;j++){
                    board[i][j] = row.charAt(j);
                    if (board[i][j] == 'o') {
                        start = new int[]{i, j};
                    }
                    if (board[i][j] == '*') {
                        dirties.add(new int[]{i, j});
                    }
                }
            }
            order = new int[dirties.size()];
            visited = new boolean[dirties.size()];
            Arrays.fill(order, -1);
            distBetweenDirties = new int[dirties.size()][n][m];

            calculateDist(start);
            solve(start,0);
            if (answer == Integer.MAX_VALUE) {
                answer = -1;
            }
            System.out.println(answer);
        }
    }

    public static void solve(int[] start, int cnt) {
        if (cnt == dirties.size()) {
            int sum = sumDist();
            answer = Math.min(answer,sum);
            return;
        }

        for(int i=0; i<dirties.size();i++){
            if(visited[i]) continue;
            order[cnt]=i;
            visited[i]=true;
            solve(start, cnt+1);
            visited[i]=false;
        }
    }

    private static int sumDist() {
        int sum =0;
        int[] nxt=null;
        int curMark= order[0];
        sum += startToDirtiesDist[dirties.get(order[0])[0]][dirties.get(order[0])[1]];
        for(int i=1; i<dirties.size();i++){
            nxt = dirties.get(order[i]);
            if (distBetweenDirties[curMark][nxt[0]][nxt[1]] == -1) {
                return Integer.MAX_VALUE;
            }
            sum+= distBetweenDirties[curMark][nxt[0]][nxt[1]];
            curMark= order[i];
        }
        return sum;
    }

    public static void calculateDist(int[] startLoc) {
        bfs(startLoc, startToDirtiesDist);
        for(int i=0; i<dirties.size();i++){
            bfs(dirties.get(i), distBetweenDirties[i]);
        }
    }

    public static void bfs(int[] start, int[][] distArr) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        for(int i=0; i<distArr.length;i++){
            Arrays.fill(distArr[i], -1);
        }
        distArr[start[0]][start[1]]=0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0;dir<4;dir++){
                int ny = dy[dir]+cur[0];
                int nx = dx[dir]+cur[1];

                if(ny<0 || ny>=n ||nx<0 ||nx>=m) continue;
                if(distArr[ny][nx]!= -1|| board[ny][nx]=='x') continue;
                distArr[ny][nx]=distArr[cur[0]][cur[1]]+1;
                q.offer(new int[]{ny, nx});
            }
        }
    }
}
