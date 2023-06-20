package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수_구하기_1929_시뮬 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int n, m, t;
    public static int[][] arr;
    public static int[][] orders;
    public static int[] tmp;
    public static boolean[] visited;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[m + 1];

        isPrime[1] = true;
        solvePrimes(isPrime);

        for(int i=n; i<=m;i++){
            if(isPrime[i]) continue;
            System.out.println(i);
        }
    }

    public static void solvePrimes(boolean[] isPrime) {
        for(int i=2;i<=Math.sqrt(m);i++){
            if(isPrime[i]) continue;
            for(int j=i+i; j<=m; j+=i){
                if(isPrime[j]) continue;
                isPrime[j]=true;
            }
        }
    }
}
