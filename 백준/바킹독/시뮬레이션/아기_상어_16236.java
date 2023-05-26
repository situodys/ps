package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기_상어_16236 {

    public static int n, m, k;
    public static int dy[] = {0, 0, -1, 1, 1, 1, -1, -1};
    public static int dx[] = {1, -1, 0, 0, 1, -1, 1, -1};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[][] board;
    public static int[][] visited;
    public static long answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        Shark shark=null;

        Queue<int[]> q = new LinkedList<>();

        visited= new int[n][n];
        PriorityQueue<Shark> pq = new PriorityQueue<>();


        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0);
                    q.offer(new int[]{i, j});
                    visited[i][j]=1;
                }
            }
        }

        int time=0;
        while(true){


            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for(int dir=0; dir<4; dir++){
                    int ny= cur[0]+dy[dir];
                    int nx = cur[1]+dx[dir];

                    if(ny<0 || ny>=n || nx<0 ||nx>=n) continue;
                    if (visited[ny][nx] != 0|| shark.size<board[ny][nx]) {
                        continue;
                    }
                    if (board[ny][nx] < shark.size && board[ny][nx] != 0) {
                        visited[ny][nx] =visited[cur[0]][cur[1]]+1;
                        pq.offer(new Shark(ny, nx, board[ny][nx], visited[cur[0]][cur[1]]));
                        continue;
                    }
                    visited[ny][nx] = visited[cur[0]][cur[1]]+1;
                    q.offer(new int[]{ny, nx});
                }
            }

            if (pq.isEmpty()) {
                break;
            }
            Shark nextLoc = pq.poll();
            time+=nextLoc.len;
            board[shark.y][shark.x]=0;
            board[nextLoc.y][nextLoc.x]=9;
            shark.y= nextLoc.y;
            shark.x=nextLoc.x;
            shark.len++;
            if (shark.len == shark.size) {
                shark.size++;
                shark.len=0;
            }

            visited=new int[n][n];
            visited[shark.y][shark.x]=1;
            q.offer(new int[]{shark.y, shark.x});
            pq.clear();
        }

        System.out.println(time);

    }

    static class Shark implements Comparable{
        public int y;
        public int x;
        public int size;
        public int len;

        public Shark(int y, int x, int size, int len) {
            this.y=y;
            this.x=x;
            this.size=size;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "y=" + y +
                    ", x=" + x +
                    ", size=" + size +
                    ", len=" + len +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            Shark s = (Shark) o;
            if (s.len == this.len) {
                if(s.y==this.y)
                    return x-s.x;
                return y-s.y;
            }
            return len-s.len;
        }
    }
}
