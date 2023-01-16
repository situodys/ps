package ps.프로그래머스.lv2;
import java.lang.*;
import java.util.*;

public class 튜플 {

    public int[] solution(String s) {
        int[] answer = {};
        Set<String> mp = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        ArrayList<ArrayList<String>> splited = new ArrayList<>();
        ArrayList<String> st = new ArrayList<>();

        ArrayList<String> tmp = new ArrayList<>();

        for(int i=1; i<s.length()-1;i++){

            if(s.charAt(i)=='{'){
                st = new ArrayList<>();
                continue;
            }
            if(s.charAt(i)==','){
                if(sb.length()==0) continue;
                st.add(sb.toString());
                sb= new StringBuilder();
                continue;
            }
            if(s.charAt(i)=='}') {
                if(sb.length()==0) continue;
                st.add(sb.toString());
                sb= new StringBuilder();
                splited.add(st);
                continue;
            }
            sb.append(s.charAt(i));
        }


        splited.sort((s1, s2) -> s1.size()-s2.size());

        for(ArrayList<String> arr : splited){
            for(String c : arr){
                if(mp.contains(c)) continue;
                mp.add(c);
                tmp.add(c);
            }
        }

        answer = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            answer[i]= Integer.parseInt(tmp.get(i));
        }


        return answer;
    }

    /*
    * Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")   ) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    * */

}
