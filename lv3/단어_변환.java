package programmers.lv3;

import java.util.*;

public class 단어_변환 {
    public int solution(String begin, String target, String[] words) {

        Queue<String> q = new LinkedList<>();
        int[] visited = new int[words.length];
        Map<String,Integer> vis = new HashMap<>();
        q.offer(begin);

        while(!q.isEmpty()){
            String cur = q.poll();
            for(int i=0; i<words.length;i++){
                if(visited[i]!=0) continue;
                if(countDifferentChars(cur,words[i]) != 1) continue;
                if(words[i].equals(target)){
                    return vis.getOrDefault(cur,0)+1;
                }
                q.offer(words[i]);
                vis.put(words[i],vis.getOrDefault(cur,0)+1);
                visited[i]=1;
            }
        }
        return 0;
    }

    public int countDifferentChars(String target, String cur){
        int ans=0;
        for(int i=0 ;i< target.length();i++){
            if(target.charAt(i) == cur.charAt(i))
                continue;
            ans++;
        }
        return ans;
    }
}
