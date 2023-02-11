package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 정수_삼각형_1932 {
    public static int[][] dp = new int[41][2];
    public static int[][] triangles;
    public static int t,n,answer;
    public static void main(String[] args) throws Exception{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        triangles= new int[n][n];
        dp= new int[n][n];

        for(int i=0 ;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++){
                triangles[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0]=triangles[0][0];

        for(int i=1 ;i<n;i++){
            dp[i][0] = triangles[i][0]+dp[i-1][0];
            dp[i][i] = dp[i-1][i-1]+triangles[i][i];
        }

        for(int i=2; i<n;i++){
            for(int j=1; j<i; j++){
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j])+triangles[i][j];
            }
        }

        for(int i=0; i<n;i++){
            answer = Math.max(answer, dp[n - 1][i]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
