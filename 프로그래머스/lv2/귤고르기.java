package ps.프로그래머스.lv2;

import java.util.*;
import java.util.stream.Collectors;

public class 귤고르기 {
    public static Map<Integer,Integer> countPerItem = new HashMap<>();
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        for(int value : tangerine){
            countPerItem.put(value,countPerItem.getOrDefault(value,0)+1);
        }

        List<Integer> lst = countPerItem.values().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for(int val : lst){
            if(k<=0) return answer;
            k-=val;
            answer++;
        }


        return answer;
    }
}
