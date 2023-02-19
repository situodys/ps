package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 암호코드_2011 {
    public static int answer;
    public static char[] cryptCode;
    public static int dp[][];
    public static final int MOD = 1000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        cryptCode = br.readLine().toCharArray();

        dp = new int[cryptCode.length + 1][2];

        int len = cryptCode.length;

        dp[1][0] = cryptCode[0] == '0' ? 0 : 1;
        dp[0][1] = 1;

        for (int i = 2; i <= len; i++) {
            if (cryptCode[i - 1] != '0') {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            }
            int len2Value = (cryptCode[i - 2] - '0') * 10 + (cryptCode[i - 1] - '0');
            if (10 <= len2Value && len2Value <= 26) {
                dp[i][1] = (dp[i - 2][0] + dp[i - 2][1]) % MOD;
            }
        }
        bw.write(String.valueOf((dp[len][0] + dp[len][1]) % MOD));

        bw.flush();
        bw.close();
    }
}
