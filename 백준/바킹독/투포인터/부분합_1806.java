package ps.백준.바킹독.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 부분합_1806 {

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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int lo=0,hi=0;
        int sum = numbers[0];
        while (true) {
            if (sum < m) {
                hi++;
                if (hi < n) {
                    sum += numbers[hi];
                }
                else break;
            }
            else{
                answer = Math.min(answer, hi - lo + 1);
                if(lo<n)
                    sum-=numbers[lo];
                else break;
                lo++;
            }
        }

        bw.write("" + (answer==Integer.MAX_VALUE ? 0:answer));
        bw.flush();
        bw.close();
    }
}
