package ps.프로그래머스.lv2;

import java.util.ArrayList;
import java.util.List;

public class 하노이탑 {

    public static List<int[]> ans = new ArrayList<>();

    public int[][] solution(int n) {
        int[][] answer = {};

        solve(n,1,3,2);

        answer = new int[ans.size()][];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }

    public void storeMove(int from, int to){
        ans.add(new int[]{from,to});
    }

    public void solve(int n, int from, int to, int by){
        if(n==1){
            storeMove(from,to);
            return;
        }

        solve(n-1,from,by,to);
        storeMove(from,to);
        solve(n-1,by,to,from);
    }
}
