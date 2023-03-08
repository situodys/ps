package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 과자_나눠주기_16401 {

    public static int n, k;
    public static int[] snacks;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        snacks = new int[k];

        for (int i = 0; i < k; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snacks);

        solve();

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }

    private static void solve() {
        int st = 0, en = snacks[k-1]+1;
        int mid;
        while (st + 1 < en) {
            mid = (st+en)/2;
            if (isEnoughLength(mid)) {
                st = mid;
                answer = Math.max(answer, mid);
            }
            else{
                en = mid;
            }
        }
    }

    private static boolean isEnoughLength(int len) {
        int cnt=0;
        if (len == 0) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            cnt += snacks[i] / len;
        }
        return cnt >=n;
    }
}
