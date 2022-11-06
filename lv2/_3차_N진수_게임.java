package programmers.lv2;
import java.lang.*;


public class _3차_N진수_게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int ansCnt = 0;
        int cur = 0;
        int order = 1;
        String convertedVal;

        while (ansCnt < t) {

            convertedVal = Integer.toString(cur, n).toUpperCase();
            for (int i = 0; i < convertedVal.length(); i++) {
                if (order % m == p % m) {
                    if (ansCnt < t) {
                        answer.append(convertedVal.charAt(i));
                        ansCnt++;
                    }
                }
                order++;
            }
            cur++;
        }

        return answer.toString();
    }
}
