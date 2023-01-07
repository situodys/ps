package programmers.lv1;

public class 기사단원의_무기 {

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i=1; i<=number;i++){
            int tmp=0;
            for(int j=1; j<=Math.sqrt(i); j++){
                if(j*j==i){
                    tmp++;
                    continue;
                }
                if(i%j==0) tmp+=2;
            }
            if(tmp>limit) answer+=power;
            else answer+=tmp;
        }


        return answer;
    }
}
