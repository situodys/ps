package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int[] visited;
    public static int[] board;
    public static int answer=Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        visited = new int[100001];
        Arrays.fill(visited, -1);
        q.offer(n);
        visited[n]=0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur - 1 == m || cur+1 == m) {
                if(visited[m]==-1) visited[m]=visited[cur]+1;
                else visited[m] = Math.min(visited[m], visited[cur] + 1);
            }
            if (cur * 2 == m) {
                if(visited[m]==-1) visited[m]=visited[cur];
                else visited[m] = Math.min(visited[m], visited[cur]);
            }
            if(cur -1 ==m || cur+1==m ||cur*2==m ) continue;
            if(cur-1 >=0){
                if (visited[cur - 1] == -1) {
                    visited[cur - 1] = visited[cur] + 1;
                    q.offer(cur - 1);
                }
                else {
                    if(visited[cur - 1] > visited[cur] + 1) {
                        visited[cur - 1] = visited[cur] + 1;
                        q.offer(cur - 1);
                    }
                }
            }

            if(cur+1 <=100000){
                if (visited[cur + 1] == -1) {
                    visited[cur + 1] = visited[cur] + 1;
                    q.offer(cur + 1);
                }else{
                    if (visited[cur + 1] > visited[cur] + 1) {
                        visited[cur + 1] = visited[cur] + 1;
                        q.offer(cur + 1);
                    }
                }
            }

            if(cur*2 <= 100000){
                if (visited[cur*2] == -1) {
                    visited[cur*2] = visited[cur];
                    q.offer(cur * 2);
                }else{
                    if (visited[cur *2] > visited[cur]) {
                        visited[cur *2] = visited[cur];
                        q.offer(cur * 2);
                    }
                }
            }
        }
        System.out.println(visited[m]);
    }
}
