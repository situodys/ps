package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 가장_가까운_같은_글자 {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        int[] count = new int[26];

        for(int i=0; i<26;i++){
            count[i]=-1;
        }

        for(int i=0;i<s.length();i++){
            int cur = count[s.charAt(i)-'a'];
            if(cur==-1){
                answer.add(-1);
                count[s.charAt(i)-'a'] =i;
                continue;
            }
            answer.add(i-cur);
            count[s.charAt(i)-'a'] =i;
        }
        int[] ans = new int[s.length()];
        for(int i=0; i<s.length();i++){
            ans[i]= answer.get(i);
        }
        return ans;
    }
}
