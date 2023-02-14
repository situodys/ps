package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 퇴사_14501 {
    public static int n,tc;
    public static int dp[];
    public static int periods[], pays[];
    public static boolean flag[];
    public static int answer = 0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new int[n];
        periods = new int[n];
        pays = new int[n];
        flag = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            periods[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
            if(periods[i]+i <=n) flag[i]=true;
        }

        for (int i = 0; i < n; i++) {
            if (flag[i]) {
                dp[i]= pays[i];
            }
            for(int j=0; j<i;j++){
                if (i - j >= periods[j]) {
                    if(flag[i]){
                        dp[i] = Math.max(dp[j]+pays[i], dp[i]);
                        continue;
                    }
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer,dp[i]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
