package ps.백준.바킹독.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 공통_부분_문자열_5582 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int n, m, t;

    public static int answer;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int[][] cnts = new int[a.length()+1][b.length()+1];

        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length();j++){
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cnts[i][j] = cnts[i - 1][j - 1] + 1;
                    answer = Math.max(answer, cnts[i][j]);
                }
            }
        }

        System.out.println(answer);
    }
}
