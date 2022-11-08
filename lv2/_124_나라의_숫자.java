package programmers.lv2;

public class _124_나라의_숫자 {
    public static int[] cand =new int[]{1,2,4};
    public String solution(int n) {
        return convert(n);
    }

    public String convert(int n){
        int tmp  =n;
        int cur;
        StringBuilder sb = new StringBuilder();

        while(tmp>0){
            cur =(tmp-1)%3;
            sb.append(cand[cur]);
            tmp = (tmp-1)/3;
        }

        return sb.reverse().toString();
    }
}
