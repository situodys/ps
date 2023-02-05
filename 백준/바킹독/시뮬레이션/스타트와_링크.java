package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와_링크 {

    public static int n;
    public static int[][] scores;
    public static boolean[] visited;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        scores = new int[n][n];
        visited = new boolean[n];

        for(int i=0 ; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n;j++){
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int idx) {
        if (depth == n / 2) {
            answer = Math.min(answer,calculateDiff() );
            return;
        }

        for(int i=idx; i<n;i++){
            if(visited[i]) continue;
            visited[i]= true;
            dfs(depth+1,i);
            visited[i]=false;
        }
    }

    public static int calculateDiff() {
        int diff=0;
        for(int i=0 ; i<n;i++){
            for(int j=i+1; j<n;j++){
                if(visited[i] != visited[j]) continue;
                if (!visited[i]) {
                    diff -= (scores[i][j] + scores[j][i]);
                    continue;
                }
                diff += (scores[i][j] + scores[j][i]);
            }
        }
        return Math.abs(diff);
    }
}
