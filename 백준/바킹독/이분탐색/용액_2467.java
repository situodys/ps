package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용액_2467 {

    public static int n;
    public static int[] liquid;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static int answer= Integer.MAX_VALUE;
    private static int[] pair;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        liquid = new int[n];
        pair = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        pair[0]=liquid[0];
        pair[1]=liquid[1];

        int start=0, end= liquid.length-1;

        while (start< end) {
            int sum = liquid[start] + liquid[end];

            if (sum < 0) {
                if (answer > 0 - sum) {
                    answer = 0-sum;
                    pair[0]=liquid[start];
                    pair[1]=liquid[end];
                }
                start++;
            }
            else{
                if (answer > sum) {
                    answer = sum;
                    pair[0]=liquid[start];
                    pair[1]=liquid[end];
                }
                end--;
            }
        }

        bw.write(pair[0]+" "+pair[1]);
        bw.flush();
        bw.close();

    }
}
