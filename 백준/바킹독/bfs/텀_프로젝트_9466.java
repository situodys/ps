package ps.백준.바킹독.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 텀_프로젝트_9466 {

    public static int n, m, r;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[][] dst;
    public static int visited[];
    public static int[] students = new int[n + 1];
    public static StringBuilder sb = new StringBuilder();
    private static int answer = Integer.MAX_VALUE;
    private static final int MAX_DIST = 200000001;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            students = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }
            visited = new int[n + 1];

            int haveTeam =0;
            for(int i=1; i<=n;i++){
                if (students[i] == i) {
                    haveTeam++;
                    visited[i]=-1;
                }
            }


            for(int i=1; i<=n;i++){
                if(visited[i] != 0) continue;
                visited[i]=1;
                haveTeam += countTeamMembers(i);
            }

            System.out.println(n - haveTeam);
        }
    }

    private static int countTeamMembers(int root) {
        Stack<Integer> stack = new Stack<>();
        int cur = root;
        stack.add(cur);
        while(true){
            int next = students[cur];
            if (visited[next] != 0) {
                if (stack.isEmpty() || !stack.contains(next)) {
                    return 0;
                }
                return stack.size() - stack.indexOf(next);
            }
            visited[next]=1;
            stack.add(next);
            cur=next;
        }
    }
}
