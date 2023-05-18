package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_바이토닉_부분_수열_11054 {
    public static int n, m, a, b, c;
    public static int dy[] = {0, 0, -1, 1, 0, 0};
    public static int dx[] = {1, -1, 0, 0, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[] ascDp;
    public static int[] descDp;
    public static int[] weights;
    public static int[] values;
    public static int answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        values= new int[n];
        ascDp = new int[n];
        descDp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            values[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n;i++){
            ascDp[i] = 1;
            descDp[i]=1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (values[j] < values[i]) {
                    ascDp[i] = Math.max(ascDp[i], ascDp[j] + 1);
                }
            }
        }

        for (int i = n-1; i >=0; i--) {
            for (int j = n-1; j >i; j--) {
                if (values[j] < values[i]) {
                    descDp[i] = Math.max(descDp[i], descDp[j] + 1);
                }
            }
        }
        int answer=0;
        for(int i=0; i<n;i++){
            answer = Math.max(answer, ascDp[i] + descDp[i]-1);
        }
        System.out.println(answer);
    }
}
