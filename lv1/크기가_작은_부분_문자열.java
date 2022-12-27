package programmers.lv1;

public class 크기가_작은_부분_문자열 {
    public int solution(String t, String p) {
        int answer = 0;
        int tLen = t.length();
        int targetLen = p.length();
        long targetVal = Long.parseLong(p);


        for(int i=0; i<= tLen-targetLen;i++){
            String cur = t.substring(i,i+targetLen);
            if(Long.parseLong(cur) <= targetVal)
                answer++;
        }

        return answer;
    }
}
