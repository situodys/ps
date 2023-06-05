package ps.백준.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A와_B_12904_문자열 {
    public static int n;
    public static String target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cur = br.readLine();
        target = br.readLine();

        StringBuilder sb = new StringBuilder(target);

        int isPossible=0;
        while (sb.length() != 0) {
            if (sb.toString().equals(cur)) {
                isPossible=1;
                break;
            }
            if (sb.charAt(sb.length() - 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }
        System.out.println(isPossible);
    }
}
