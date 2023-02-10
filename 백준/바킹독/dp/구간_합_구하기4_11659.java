package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기4_11659 {

    public static int n,m;
    public static int numbers[] = new int[1000001];
    public static int dp[] = new int[1000001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1 ;i<=n;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
            if (i == 1) {
                dp[i] = numbers[i];
                continue;
            }
            dp[i] = dp[i-1]+numbers[i];
        }

        int start, end;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            System.out.println(dp[end]-dp[start-1]);
        }
    }
}
