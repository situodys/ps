package ps.프로그래머스.lv2;
import java.util.*;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int left=0;
        int right =0;
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }

        while(right<=discount.length){
            if(right-left == 10){
                if (check(map,want)){
                    answer++;
                }
                map.put(discount[left],map.get(discount[left])+1);
                left++;
            }
            if(right == discount.length ) break;
            if(map.get(discount[right]) == null){
                while(left != right){
                    map.put(discount[left],map.get(discount[left])+1);
                    left++;
                }
                left++;
                right++;
                continue;
            }
            map.put(discount[right],map.get(discount[right])-1);
            right++;
        }

        return answer;
    }

    public boolean check(Map<String,Integer> map, String[] want){
        for(String item : want){
            if(map.get(item) !=0)
                return false;
        }
        return true;
    }
}
