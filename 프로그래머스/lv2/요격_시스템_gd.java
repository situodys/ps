package ps.프로그래머스.lv2;

import java.util.*z`;

public class 요격_시스템_gd {
    public int solution(int[][] targets) {
        int answer = 0;
        int cur=-1;

        Arrays.sort(targets,Comparator.comparingInt((int[] a)->a[1]));

        for(int i=0; i<targets.length;i++){
            if(cur<=targets[i][0]){
                answer++;
                cur=targets[i][1];
            }
        }
        return answer;
    }
}
