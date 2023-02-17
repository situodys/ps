package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 동전_9084 {

    public static int t,n,target;
    public static int[] coins;
    public static int dp[];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            coins =new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0 ;i<n;i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            target = Integer.parseInt(br.readLine());
            dp = new int[target + 1];

            dp[0]=1;

            for(int i=0; i<n;i++){
                for(int j = coins[i]; j<= target; j++){
                    dp[j] += dp[j-coins[i]];
                }
            }

            bw.write(dp[target]+"\n");
        }

        bw.flush();
        bw.close();
    }
}
