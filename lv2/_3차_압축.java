package programmers.lv2;
import java.util.*;

public class _3차_압축 {

    //2018 kakao blind
    public int[] solution(String msg) {
        int[] answer = {};

        Map<String,Integer> zip = new HashMap<>();
        ArrayList<Integer> index = new ArrayList<>();

        String tmp="";
        String prev="";

        for(int i=0;i<26;i++){
            zip.put(String.valueOf((char)('A'+i)),i+1);
        }

        for(int i=0;i<msg.length();){
            tmp+=msg.charAt(i);
            while(true){
                if(zip.get(tmp) != null){
                    prev=tmp;
                    i++;
                    if(i==msg.length()) {
                        index.add(zip.get(prev));
                        break;
                    }
                    tmp+=msg.charAt(i);
                    continue;
                }
                index.add(zip.get(prev));
                break;
            }
            zip.put(tmp,zip.size()+1);
            tmp="";
        }

        answer = new int[index.size()];
        for(int i=0;i<index.size();i++){
            answer[i]= index.get(i);
        }
        return answer;
    }
}
