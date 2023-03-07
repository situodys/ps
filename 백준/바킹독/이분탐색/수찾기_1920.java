package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920 {

    public static int n, k;
    public static int[] numbers,targets;

    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        numbers = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        k = Integer.parseInt(br.readLine());

        targets = new int[k];

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
            if (numbersContain(targets[i])) {
                sb.append(1 + "\n");
            } else {
                sb.append(0 + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean numbersContain(int x) {
        int st = -1, en = n;
        int mid;
        while (st + 1 < en) {
            mid = (st+en)/2;
            if (numbers[mid] == x) {
                return true;
            }
            if (numbers[mid] < x) {
                st = mid;
                continue;
            }
            en = mid;
        }
        return false;
    }
}
