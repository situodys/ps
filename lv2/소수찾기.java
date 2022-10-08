package programmers.lv2;

import java.lang.*;
import java.util.*;

public class 소수찾기 {

    public static boolean[] arr = new boolean[10000001];
    public static String target;
    public static int answer;
    public static boolean[] visited;
    public static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        answer = 0;
        target= numbers;
        init();
        visited= new boolean[numbers.length()];
        for(int i=1;i<=numbers.length();i++){
            StringBuilder sb= new StringBuilder();
            dfs(i,sb, 0);
        }

        return answer;
    }

    public void init(){
        arr[0]=true; arr[1]=true;
        for(int i=2; i<=10000; i++){
            if(arr[i] == true) continue;
            for(int j=i+i; j<10000000; j+=i){
                arr[j]=true;
            }
        }
    }

    public void dfs(int n, StringBuilder cur, int cnt){
        if(n==cnt){
            int cal =Integer.parseInt(cur.toString());
            if(!arr[cal] && !set.contains(cal)){
                answer++;
                set.add(cal);
                return;
            }
        }
        for(int i=0;i<target.length();i++){
            if(visited[i]) continue;
            visited[i]=true;
            cur.append(target.charAt(i));
            dfs(n,cur,cnt+1);
            cur.deleteCharAt(cnt);
            visited[i]=false;
        }
    }
}
