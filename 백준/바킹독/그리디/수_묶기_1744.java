package ps.백준.바킹독.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 수_묶기_1744 {

    public static int n, m;
    public static List<Integer> notPositiveNumbers;
    public static List<Integer> positiveNumbers;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        notPositiveNumbers = new ArrayList<>();
        positiveNumbers = new ArrayList<>();

        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(br.readLine());
            if (tmp <= 0) {
                notPositiveNumbers.add(tmp);
                continue;
            }
            positiveNumbers.add(tmp);
        }

        notPositiveNumbers.sort(Comparator.naturalOrder());
        positiveNumbers.sort(Comparator.reverseOrder());

        int notPositiveNumbersLength = notPositiveNumbers.size();

        for (int i = 0; i < notPositiveNumbersLength - 1; i += 2) {
            answer += notPositiveNumbers.get(i) * notPositiveNumbers.get(i + 1);
        }

        if (notPositiveNumbersLength % 2 == 1) {
            answer += notPositiveNumbers.get(notPositiveNumbersLength - 1);
        }

        int positiveNumbersLength = positiveNumbers.size();

        for (int i = 0; i < positiveNumbersLength - 1; i += 2) {
            int first = positiveNumbers.get(i);
            int second = positiveNumbers.get(i + 1);

            if (first == 1 || second == 1) {
                answer += first;
                answer += second;
                continue;
            }
            answer += first * second;
        }

        if (positiveNumbersLength % 2 == 1) {
            answer += positiveNumbers.get(positiveNumbersLength - 1);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
