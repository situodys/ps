package programmers.lv2;

public class 삼각_달팽이 {
    //10:00~10:31
    public static int[][] ans;

    public int[] solution(int n) {
        int[] answer = {};
        ans = new int[n][];

        for(int i=0;i<n;i++){
            ans[i]=new int[i+1];
        }

        dfs(n,1,0,0);

        answer =new int[n*(n+1)/2];

        int idx =0;

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                answer[idx] = ans[i][j];
                idx++;
            }
        }
        return answer;
    }

    public void dfs(int len, int startV,int y, int x){
        if(len<0){
            return;
        }

        int v= startV;

        for(int i=0; i<len;i++){
            ans[y+i][x]= v;
            v++;
        }

        for(int i=1; i<len;i++){
            ans[y+len-1][x+i] = v;
            v++;
        }

        for(int i=len-2; i>0; i--){
            ans[y+i][x+i]= v;
            v++;
        }

        dfs(len-3,v,y+2,x+1);
    }
}
