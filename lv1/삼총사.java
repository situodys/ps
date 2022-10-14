package programmers.lv1;

public class 삼총사 {
    public static int answer = 0;
    public static int[] target;

    public int solution(int[] number) {
        target= number;
        dfs(0,0,0);
        return answer;
    }

    public void dfs(int cnt,int idx, int sum){
        if(cnt == 3){
            if(sum==0){
                answer++;
            }
            return;
        }
        for(int i=idx;i<target.length;i++){
            dfs(cnt+1,i+1,sum+target[i]);
        }
    }
}
