package ps.프로그래머스.lv3;

import java.util.Arrays;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        int cam = -30001;

        Arrays.sort(routes,(int[] a, int[] b) ->{
            return a[1]-b[1];
        });

        for(int i=0; i<routes.length;i++){
            if(cam < routes[i][0]){
                answer++;
                cam=routes[i][1];
            }
        }

        return answer;
    }
}
