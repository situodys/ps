package ps.프로그래머스.lv2;

public class 마법의_엘리베이터 {
    public static int answer = Integer.MAX_VALUE;
    public static int len=0;
    public int solution(int storey) {

        int tmp= storey;
        while(tmp !=0){
            tmp/=10;
            len++;
        }

        dfs(0,storey,0);
        return answer;
    }

    public void dfs(int cnt, int target,int idx){
        if(target==0 || idx==len+1){
            answer = Math.min(answer,cnt);
            return;
        }
        int cur = target%10;

        dfs(cnt+cur,(target-cur)/10,idx+1);
        dfs(cnt+(10-cur),(target+(10-cur))/10,idx+1);
    }
}
