package programmers.lv3;

import java.util.*;
import java.util.stream.Collectors;

public class 베스트앨범 {

    /*
    1시간+30분
    getOrDefault 잘못써서 30분 더
     */
    public static Map<String, List<Info>> genreMap = new HashMap<>();
    public static Map<String, Integer> sumMap = new HashMap<>();
    public static List<Integer> ans = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        for(int i=0; i<genres.length;i++){
            String genre = genres[i];
            int val = plays[i];
            List<Info> infos = genreMap.getOrDefault(genre,new ArrayList<>());
            infos.add(new Info(i,val));
            genreMap.put(genre,infos);

            sumMap.put(genre,sumMap.getOrDefault(genre,0)+val);
        }

        List<String> sortedGenre = new ArrayList<>(sumMap.keySet());
        sortedGenre.sort((s1,s2)->sumMap.get(s2)-sumMap.get(s1));

        for(int i=0;i< sortedGenre.size();i++){
            String g = sortedGenre.get(i);
            appendIndex(g,ans);
        }

        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }

        return answer;
    }

    public void appendIndex(String g, List<Integer> ans){
        List<Info> info = genreMap.get(g);

        List<Integer> plays = info.stream()
                .sorted((info1,info2)->{
                    if(info1.plays==info2.plays){
                        return info1.index-info2.index;
                    }
                    return info2.plays-info1.plays;
                })
                .map(inf->inf.index)
                .limit(2)
                .collect(Collectors.toList());

        for(int i=0;i<plays.size();i++){
            ans.add(plays.get(i));
        }
    }

    class Info {
        public int index;
        public int plays;

        public Info(int index, int plays){
            this.index=index;
            this.plays= plays;
        }
    }
}
