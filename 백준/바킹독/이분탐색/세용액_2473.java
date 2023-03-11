package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액_2473 {

    public static int n;
    public static long[] liquids;
    public static long l1, l2, l3;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer= Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        liquids = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquids);

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                long first = liquids[i];
                long second = liquids[j];

                int start= j;
                int end = n;

                while (start + 1 < end) {
                    int mid = (start+end)/2;
                    long sum = first + second + liquids[mid];
                    if (sum == 0) {
                        bw.write("" + first + " " + second + " " + liquids[mid]);
                        bw.flush();
                        bw.close();
                        return;
                    }
                    if (sum < 0) {
                        if (-sum < answer) {
                            answer =-sum;
                            l1=first; l2=second; l3=liquids[mid];
                        }
                        start = mid;
                    } else {
                        if (sum < answer) {
                            answer=sum;
                            l1=first; l2=second; l3=liquids[mid];
                        }
                        end = mid;
                    }
                }
            }
        }

        bw.write("" + l1 + " " + l2 + " " + l3);
        bw.flush();
        bw.close();
    }
}
