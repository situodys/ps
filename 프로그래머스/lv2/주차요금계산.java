package ps.프로그래머스.lv2;
import java.lang.*;
import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, ArrayList<Integer>> mp = new HashMap<>();
        ArrayList<String> carNo = new ArrayList<>();

        String[] splitedRecord;
        String[] splitedTime;

        int time;

        for(int i=0;i<records.length;i++){
            splitedRecord = records[i].split("[ ]");
            splitedTime = splitedRecord[0].split("[:]");

            time = Integer.parseInt(splitedTime[0])*60 + Integer.parseInt(splitedTime[1]);

            if(mp.get(splitedRecord[1]) == null){
                carNo.add(splitedRecord[1]);
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(time);
                mp.put(splitedRecord[1],tmp);
                continue;
            }
            mp.get(splitedRecord[1]).add(time);
        }

        answer = new int[carNo.size()];
        Collections.sort(carNo);

        ArrayList<Integer> arr;
        int carTime=0;
        int maxTime = 23*60+59;
        int carFee=0;
        int idx=0;

        for(String key : carNo){
            arr = mp.get(key);
            carTime=0;
            carFee=0;
            int calTime;
            for(int i=0;i<arr.size();i+=2){
                if(arr.size()%2 ==1 && i==arr.size()-1){
                    carTime += maxTime-arr.get(i);
                    break;
                }
                carTime += arr.get(i+1)-arr.get(i);
            }
            if((carTime-defaultTime) % unitTime == 0){
                calTime = (carTime-defaultTime)/unitTime;
            }
            else calTime = (carTime-defaultTime)/unitTime + 1;

            carFee = carTime > defaultTime ? defaultFee+ calTime*unitFee : defaultFee;
            answer[idx]=carFee;
            idx++;

        }
        return answer;
    }
}
