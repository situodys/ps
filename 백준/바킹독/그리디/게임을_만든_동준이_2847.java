package ps.백준.바킹독.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 게임을_만든_동준이_2847 {

    public static int n, t;
    public static int[] scores;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n-1; i > 0; i--) {
            if (scores[i] - scores[i - 1] == 0) {
                scores[i-1]--;
                answer++;
                continue;
            }
            if (scores[i] - scores[i - 1] < 0) {
                answer += (scores[i-1]-scores[i])+1;
                scores[i-1] = scores[i] -1;
                continue;
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
