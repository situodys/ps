package ps.프로그래머스.lv3;

import java.util.*;

public class 숫자_게임 {
    public static  List<Integer> bList = new ArrayList<>();

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(B);

        for(int i=0; i<B.length;i++){
            bList.add(B[i]);
        }

        for(int i=0; i<A.length;i++){
            int curIdx = bs(A[i]);
            if(curIdx>=bList.size()) continue;
            if(A[i] < bList.get(curIdx))
                answer++;
            bList.remove(curIdx);
        }
        return answer;
    }

    private int bs(int target){
        int lo = 0; int hi=bList.size();

        while(lo<hi){
            int mid = (lo+hi)/2;
            if(bList.get(mid)<=target){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return hi;
    }
}
