package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 숨바꼭질4_13913 {

    public static int n, m,k;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int[]visited;
    public static int[]history;
    public static int[] board;
    public static int answer=Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        history = new int[100001];
        Queue<Integer> q = new LinkedList<>();

        q.offer(n);
        visited[n]=1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            int[] cands = new int[]{cur + 1, cur - 1, cur * 2};

            for (int nxt : cands) {
                if(nxt<0 || nxt>100000) continue;
                if (visited[nxt] != 0) continue;
                visited[nxt]= visited[cur]+1;
                q.offer(nxt);
                history[nxt]=cur;
            }
        }

        System.out.println(visited[m]-1);
        int cur=m;
        Stack<Integer> stack = new Stack<>();
        stack.push(cur);
        while (true) {
            if(cur==n) break;
            cur=history[cur];
            stack.push(cur);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
}
