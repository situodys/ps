package ps.프로그래머스.lv2;
import java.util.*;

public class 위장 {

    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String,Integer> info = new HashMap<>();

        for(int i=0;i<clothes.length;i++){
            info.put(clothes[i][1],info.getOrDefault(clothes[i][1],0)+1);
        }

        answer =1;

        Set<String> keys = info.keySet();
        List<String> keyArr = new ArrayList<>(keys);

        if(keys.size() == 1){
            return info.get(keyArr.get(0));
        }

        for(String key : keyArr){
            answer*=(info.get(key)+1);
        }

        return answer-1;
    }

}
