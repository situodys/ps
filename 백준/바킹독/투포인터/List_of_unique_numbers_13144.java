package ps.백준.바킹독.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class List_of_unique_numbers_13144 {

    public static int n, m;
    public static int[] arr;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] dup = new boolean[100001];

        int hi = 0;
        dup[arr[0]] = true;
        for (int lo = 0; lo < n; lo++) {
            while (hi < n - 1) {
                if (dup[arr[hi + 1]]) {
                    break;
                }
                hi++;
                dup[arr[hi]] = true;
            }
            answer += (hi - lo + 1);
            dup[arr[lo]] = false;
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }
}
