package ps.프로그래머스.lv2;

public class 피로도 {
    public static int cnt=0;
    public static boolean[] visited;
    public static int tmp=-1;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;

        visited = new boolean[dungeons.length];
        dfs(k,0,dungeons);
        answer=tmp;
        return answer;
    }

    public void dfs(int cur, int n, int[][] dungeons){
        if(n>tmp){
            tmp=n;
        }
        for(int i=0;i<dungeons.length;i++){
            if(visited[i] || dungeons[i][0] > cur)
                continue;
            visited[i]=true;
            dfs(cur-dungeons[i][1],n+1,dungeons);
            visited[i]=false;
        }
    }
}
