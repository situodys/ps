package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선_자르기_1654 {

    public static int n, k;
    public static int[] lan;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        lan = new int[n];

        for (int i = 0; i < n; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);
        long low = 1, high=lan[n-1];

        long mid;
        long curLength=0;
        answer =1;
        while (low+1 < high) {
            mid = (low+high)/2;
            curLength = calculateLan(mid);
            if (curLength >= k) {
                answer = Math.max(answer,mid);
                low =mid;
                continue;
            }
            high =mid;
        }

        if (calculateLan((long) lan[n - 1]) >= k) {
            answer = Math.max(answer, lan[n - 1]);
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    private static long calculateLan(long mid) {
        int cnt=0;
        for (int i = 0; i < n; i++) {
            cnt+= lan[i]/mid;
        }
        return cnt;
    }
}
