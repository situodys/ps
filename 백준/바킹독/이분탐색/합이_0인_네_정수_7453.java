package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이_0인_네_정수_7453 {

    public static int n;
    public static int[][] numbers;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int[] result1;
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        numbers = new int[4][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                numbers[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        storeSumOfTwo(numbers[0], numbers[1]);

        Arrays.sort(result1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = -numbers[2][i] - numbers[3][j];
                answer += (upperBound(target) - lowerBound(target));
            }
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }

    private static int lowerBound(int x) {
        int st=-1,en=result1.length;
        while (st + 1 < en) {
            int mid = (st+en)/2;
            int cur = result1[mid];
            if (cur < x) {
                st=mid;
            }
            else en=mid;
        }
        return st;
    }

    private static int upperBound(int x) {
        int st=-1,en=result1.length;
        while (st + 1 < en) {
            int mid = (st+en)/2;
            int cur = result1[mid];
            if (cur <= x) {
                st=mid;
            }
            else en=mid;
        }
        return st;
    }

    private static void storeSumOfTwo(int[] number1, int[] number2) {
        result1 = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result1[i*n+j]=number1[i]+number2[j];
            }
        }
    }
}
