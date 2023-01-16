package ps.프로그래머스.lv1;

import java.util.*;

public class 과일장수 {

    public int solution(int k, int m, int[] score) {
        int ans = 0 ;
        Arrays.sort(score);

        for (int i = score.length - 1; i >= 0; i--) {
            if ((score.length - i) % m == 0) {
                ans += score[i] * m;
            }
        }
        return ans;
    }
}
