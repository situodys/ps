package programmers.lv2;

public class k진수에서_소수_개수_구하기 {
    //9:55~10:15
    /*
    0을 기준으로 ct.split("0") 하면 의미 있는 숫자들만 남길 수 있음
    */
    public int solution(int n, int k) {
        int answer = 0;

        String ct = Integer.toString(n,k);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<ct.length();i++){
            if(ct.charAt(i)=='0') {
                if(sb.length() != 0 && isPrime(Long.parseLong(sb.toString()))){
                    answer++;
                }
                sb= new StringBuilder();
                continue;
            }
            sb.append(ct.charAt(i));
        }
        if(sb.length() != 0 && isPrime(Long.parseLong(sb.toString()))){
            answer++;
        }

        //System.out.println(ct);
        return answer;
    }
    public boolean isPrime(long target){
        if(target<2) return false;
        for(int i=2; i<=Math.sqrt(target); i++){
            if(target%i ==0) return false;
        }
        return true;
    }
}
