package ps.백준.바킹독.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수_고르기_2230 {

    public static int n,m;
    public static int[] numbers;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int lo=0, hi=0;

        Arrays.sort(numbers);

        while (lo < n && hi < n && lo<=hi) {
            int left = numbers[lo];
            int right = numbers[hi];
            int diff = right-left;
            if (diff < m) {
                hi++;
            }else{
                answer = Math.min(diff, answer);
                lo++;
            }
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }
}
