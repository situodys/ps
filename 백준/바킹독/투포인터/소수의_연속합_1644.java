package ps.백준.바킹독.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 소수의_연속합_1644 {

    public static int n;
    public static List<Integer> primes;
    public static boolean[] isNotPrime;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        if (n == 1) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }

        primes = new ArrayList<>();
        isNotPrime = new boolean[n+1];

        findPrimes();
        int lo=0,hi=0;
        int sum = primes.get(0);
        int primeLength = primes.size();

        while (true) {
            if (sum == n) {
                answer ++;
                if (hi < primeLength-1) {
                    hi++;
                    sum += primes.get(hi);
                }else break;
            }
            else if (sum > n) {
                if (lo < primeLength-1) {
                    sum -= primes.get(lo);
                    lo++;
                }else break;
            }
            else{
                if (hi < primeLength-1) {
                    hi++;
                    sum += primes.get(hi);
                }else break;
            }
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }

    private static void findPrimes() {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(isNotPrime[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }
    }
}
