package ps.프로그래머스.lv2;

import java.util.Arrays;


//13:32~14:28
public class H_index {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int h=0;
        int cnt=0;

        for(int i= citations[citations.length-1]; i>0; i--){
            h=i;
            cnt=0;
            for(int j=citations.length-1; j>=0; j--){
                if(citations[j] >=h){
                    cnt++;
                    continue;
                }
                break;
            }
            if(cnt>=h)
                return h;
        }
        return answer;
    }
}
