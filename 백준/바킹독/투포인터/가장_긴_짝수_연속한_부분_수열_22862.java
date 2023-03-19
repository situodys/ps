package ps.백준.바킹독.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가장_긴_짝수_연속한_부분_수열_22862 {

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
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int hi=1, cnt=1;
        int delCnt=0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                hi = i+1;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if(arr[i]%2 != 0) {
                if(delCnt!=0) delCnt--;
                continue;
            }
            while (hi < n) {
                if (arr[hi] % 2 == 0) {
                    cnt++;
                    hi++;
                }
                else{
                    if (delCnt < m) {
                        delCnt++;
                        hi++;
                    }
                    else break;
                }
            }
            answer = Math.max(answer, hi - i - delCnt);
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }
}
