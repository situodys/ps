package programmers.lv2;

import java.util.*;
import java.lang.*;

/*
* 12:49 - 13: 56 + 1시간
* 테크 27번 해결하는데 추가로 1시간
* 시간 계산 시에 startM > endM인 경우 endM+=60해야하는걸
* startM+=60 해서 실패..
* */

public class 방금그곡 {
    public static ArrayList<Music> musics = new ArrayList<>();
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        ArrayList<Music> ans = new ArrayList<>();
        int maxPlayTime =0;

        for(String info : musicinfos){
            addToList(info);
        }

        for(Music music : musics){
            if(music.isSatisfiedCondition(m)){
                ans.add(music);
                maxPlayTime = Math.max(maxPlayTime,music.playTime);
            }
        }

        if(ans.size()==0)
            return "(None)";

        for(Music cand : ans){
            if(cand.playTime == maxPlayTime)
                return cand.name;
        }
        return answer;
    }

    public void addToList(String info){
        String[] splited = info.split("[:,]");
        int playTime = calTime(splited);
        //System.out.println(playTime);
        musics.add(new Music(playTime,splited[5],splited[4]));
    }

    public int calTime(String[] splited){
        int startH=Integer.parseInt(splited[0]); int startM=Integer.parseInt(splited[1]);
        int endH=Integer.parseInt(splited[2]); int endM=Integer.parseInt(splited[3]);

        if(startM> endM){
            endH-=1;
            endM+=60;
        }
        return (endH-startH)*60 + Math.abs(startM-endM);
    }

    class Music {
        public int playTime;
        public String r;
        public String name;

        public Music(int playTime, String r, String name){
            this.playTime=playTime;
            this.r = r;
            this.name = name;
        }

        public boolean isSatisfiedCondition(String m){
            int cnt=0;
            int idx=0;
            int rLen = r.length();
            StringBuilder sb = new StringBuilder();

            while(cnt<this.playTime){
                sb.append(this.r.charAt(idx%rLen));
                if(this.r.charAt(idx%rLen)=='#'){
                    idx++;
                    continue;
                }
                idx++;
                cnt++;
            }
            if(this.r.charAt(idx%rLen) == '#')
                sb.append(this.r.charAt(idx%rLen));
            //System.out.println(sb.toString());
            if(!sb.toString().contains(m)){
                return false;
            }
            if(m.contains("#") && !m.endsWith("#")){
                return true;
            }
            String[] tmp = sb.toString().split(m+"#");
            for(int i=0;i<tmp.length;i++){
                if(tmp[i].contains(m))
                    return true;
            }
            return false;
        }
    }
}
