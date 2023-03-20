package ps.백준.바킹독.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 겹치는건_싫어_20922 {

    public static int n, m;
    public static int[] arr,dup;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static long answer = 1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dup = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lo=0,hi=1, cnt=1;
        dup[arr[lo]]=1;

        while (hi < n) {
            if (dup[arr[hi]] >= m) {
                dup[arr[lo]] --;
                lo++;
            }
            else{
                answer = Math.max(answer,hi-lo+1);
                dup[arr[hi]]++;
                hi++;
            }
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }
}
