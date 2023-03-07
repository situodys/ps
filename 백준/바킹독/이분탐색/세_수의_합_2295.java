package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 세_수의_합_2295 {

    public static int n, k;
    public static int[] numbers;
    public static List<Integer> resultOfAddingTwoNumbers = new ArrayList<>();
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        numbers = new int[n];


        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                resultOfAddingTwoNumbers.add(numbers[i] + numbers[j]);
            }
        }

        resultOfAddingTwoNumbers.sort(Comparator.naturalOrder());

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbersContain(numbers[i] - numbers[j])) {
                    bw.write(""+numbers[i]);
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
    }

    private static boolean numbersContain(int x) {
        int st = -1, en = resultOfAddingTwoNumbers.size();
        int mid;
        while (st + 1 < en) {
            mid = (st+en)/2;
            if (resultOfAddingTwoNumbers.get(mid) == x) {
                return true;
            }
            if (resultOfAddingTwoNumbers.get(mid)< x) {
                st = mid;
                continue;
            }
            en = mid;
        }
        return false;
    }
}
