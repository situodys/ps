package programmers.lv2;

import java.util.ArrayList;

public class 가장_큰_수 {

    //10:04~10:35
    // s1+s2, s2+s1비교하는 것 검색했다.
    public String solution(int[] numbers) {
        String answer = "";

        ArrayList<String> n2s = new ArrayList<>();

        for(int number : numbers){
            n2s.add(String.valueOf(number));
        }

        n2s.sort((s1,s2)-> (s1+s2).compareToIgnoreCase(s2+s1));

        StringBuilder sb = new StringBuilder();
        int len = n2s.size();

        if(n2s.get(len-1).equals("0"))
            return "0";

        for(int i=len-1; i>=0;i--){
            sb.append(n2s.get(i));
        }
        answer = sb.toString();

        return answer;
    }
}
