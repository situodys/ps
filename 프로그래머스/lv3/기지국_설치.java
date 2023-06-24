package ps.프로그래머스.lv3;

public class 기지국_설치 {
    public int solution(int n, int[] stations, int w) {

        int answer = 0;

        int idx=1;
        int station=0;

        while(idx <=n){
            if(station <stations.length && stations[station]-w <= idx){
                idx=stations[station]+w+1;
                station++;
            }else{
                answer++;
                idx +=2*w+1;
            }

        }

        return answer;
    }
}
