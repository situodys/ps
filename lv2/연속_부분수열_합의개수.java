package programmers.lv2;

import java.util.*;

public class 연속_부분수열_합의개수 {
    // 9:48~ 10:08
    public static Map<Integer,Integer> result = new HashMap<>();
    public static int[] arr;

    public int solution(int[] elements) {
        int answer = 0;

        arr = new int[elements.length*2];

        for(int i=0;i<arr.length;i++){
            if(i<elements.length){
                arr[i]= elements[i];
                continue;
            }
            arr[i]= elements[i-elements.length];
        }

        for(int i=0;i<elements.length;i++){
            calSum(i);
        }

        answer = result.size();
        return answer;
    }

    public void calSum(int idx){
        int rlt=0;
        for(int i=0;i<arr.length/2;i++){
            rlt=0;
            for(int j=0;j<idx;j++){
                rlt+= arr[i+j];
            }
            result.put(rlt,0);
        }
    }
}
