package ps.프로그래머스.lv3;

import java.util.*;

public class 보석_쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int len= 100001;

        int start=0, end=0;

        Set<String> distinctGems = new HashSet<>(List.of(gems));
        int totalGemsCnt = distinctGems.size();

        Map<String,Integer> curGems = new HashMap<>();
        curGems.put(gems[end],1);
        int currentUniqGemCnt=1;

        while(start<=end){
            if(currentUniqGemCnt < totalGemsCnt){
                end++;
                if(end==gems.length) break;
                curGems.put(gems[end],curGems.getOrDefault(gems[end],0)+1);
                if(curGems.get(gems[end]) != 1)
                    continue;
                currentUniqGemCnt++;
            }
            if(currentUniqGemCnt == totalGemsCnt){
                if(end-start+1 < len){
                    answer = new int[]{start+1,end+1};
                    len = end-start+1;
                }
                int cnt = curGems.get(gems[start]);
                if(cnt==1)
                    currentUniqGemCnt--;
                curGems.put(gems[start],cnt-1);
                start++;
            }
        }

        return answer;
    }
}
