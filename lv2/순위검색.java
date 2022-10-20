package programmers.lv2;

public class 순위검색 {
}

/*
* 틀린 풀이, 효율성 통과 못함
* import java.util.*;
import java.lang.*;

//9:35~
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
        String[] parsedQuery;
        Info target;
        for(String eachQuery : query){
            parsedQuery = eachQuery.replaceAll("and","").replaceAll("  "," ").split(" ");
            target=new Info(info);
            target= target.filterScore(parsedQuery[4]);
            for(int i=0;i<4;i++){
                target= target.filter(parsedQuery[i],i);
            }
            ans.add(target.count());
        }

        answer = new int[query.length];
        for(int i=0;i<query.length;i++){
            answer[i]=ans.get(i);
        }

        return answer;
    }

    public class Info{
        ArrayList<String[]> satisfied;

        public Info(String[] info){
            satisfied = new ArrayList<>();
            for(String s : info){
                satisfied.add(s.replaceAll("and","").replaceAll("  "," ").split(" "));
            }
        }

        public Info(ArrayList<String[]> info){
            satisfied = new ArrayList<String[]>();

            for(String[] s : info){
                satisfied.add(s);
            }
        }

        public Info filter(String lang, int idx){
            ArrayList<String[]> filteredInfo = new ArrayList<>();
            if(lang.equals("-")){
                return this;
            }
            for(String[] query : satisfied){
                if(query[idx].equals(lang)){
                    filteredInfo.add(query);
                }
            }
            return new Info(filteredInfo);
        }
        public Info filterScore(String score){
            ArrayList<String[]> filteredInfo = new ArrayList<>();

            for(String[] query : satisfied){
                if(Integer.parseInt(query[4]) >= Integer.parseInt(score)){
                    filteredInfo.add(query);
                }
            }
            return new Info(filteredInfo);
        }

        public int count(){
            return satisfied.size();
        }
    }
}
* */