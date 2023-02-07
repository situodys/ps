package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리_조작_15684 {
    //2:21~4:25
    public static int n,m,h;
    public static int[][] path;
    public static int answer=5;
    public static void main (String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        path = new int[h][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j <h; j++) {
                path[j][i] = i;
            }
        }

        int a,b;
        for(int i=0 ;i<m;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            path[a-1][b-1] = b;
            path[a-1][b]=b-1;
        }

        if (isEndAtStartPoint()) {
            System.out.println(0);
            return;
        }
        dfs(0);
        System.out.println(answer==5?-1:answer);

    }

    public static void dfs(int depth) {
        if (depth == 3) {
            return;
        }

        for(int i=0 ;i<h;i++){
            for(int j=0; j<n-1;j++){
                if ((path[i][j] == j) && (path[i][j + 1] == j + 1)) {
                    path[i][j]=j+1;
                    path[i][j+1]=j;
                    if (isEndAtStartPoint()) {
                        answer = Math.min(answer, depth+1);
                        path[i][j]=j;
                        path[i][j+1]=j+1;
                        return;
                    }
                    dfs(depth + 1);
                    path[i][j]=j;
                    path[i][j+1]=j+1;
                }
            }
        }
    }

    public static boolean isEndAtStartPoint() {
        for(int k=0 ; k<n;k++){
            int rowLoc=0;
            int destination=k;

            while(true){
                if(rowLoc==h)break;
                destination = path[rowLoc][destination];
                rowLoc++;
            }
            if(destination != k) return false;
        }
        return true;
    }
}
