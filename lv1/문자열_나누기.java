package programmers.lv1;

public class 문자열_나누기 {
    public int solution(String s) {
        int answer = 0;
        String tmp = s;

        while(true){
            char firstLetter = tmp.charAt(0);
            int sameLetterCount =0;
            int diffLetterCount =0;
            for(int i=0; i<tmp.length();i++){
                if(tmp.charAt(i)==firstLetter)
                    sameLetterCount++;
                else
                    diffLetterCount++;
                if(sameLetterCount != 0 && sameLetterCount == diffLetterCount){
                    tmp = tmp.substring(i+1);
                    break;
                }
            }
            answer++;
            if(tmp.equals(""))
                break;
            if(sameLetterCount != diffLetterCount){
                break;
            }
        }

        return answer;
    }
}
