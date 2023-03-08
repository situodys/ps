package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무_자르기_2805 {

    public static int n, k;
    public static int[] trees;
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

        trees = new int[n];

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int start=-1,end = trees[n-1]+1;
        int mid;
        while (start + 1 < end) {
            mid = (start + end)/2;
            if (isProperLength(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        bw.write("" + start);
        bw.flush();
        bw.close();
    }

    private static boolean isProperLength(int len) {
        int redundantTree = 0;
        long sum=0;
        for (int i = 0; i < n; i++) {
            redundantTree = trees[i]-len;
            if (redundantTree > 0) {
                sum += redundantTree;
            }
        }
        return sum >= k;
    }
}
