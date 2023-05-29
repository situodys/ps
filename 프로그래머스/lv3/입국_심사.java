package ps.프로그래머스.lv3;

public class 입국_심사 {
    public static long peopleCnt;
    public long solution(int n, int[] times) {
        long answer = 0;
        int maxCheckTime=0;
        for(int time : times){
            maxCheckTime = Math.max(maxCheckTime,time);
        }

        peopleCnt=(long)n;
        long lo=0; long hi=(long)maxCheckTime*(long)n;

        while(lo+1 <hi){
            long mid = (lo+hi)/2;
            if(canCheck(mid,times)){
                hi=mid;
            }
            else lo=mid;
        }
        return hi;
    }

    private boolean canCheck(long x,int[] times){
        long people=0;
        for(int time: times){
            people+=x/(long)time;
        }
        return people>=peopleCnt;
    }
}
