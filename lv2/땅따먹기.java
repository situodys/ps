package programmers.lv2;

public class 땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][land[0].length];

        for(int i=0;i<4;i++){
            dp[0][i]= land[0][i];
        }

        int tmp=0;

        for(int i=1; i<land.length;i++){
            for(int j=0;j<4;j++){
                tmp=0;
                for(int k=0;k<4;k++){
                    if(k==j) continue;
                    tmp = Math.max(tmp,dp[i-1][k]);
                }
                dp[i][j] = land[i][j]+tmp;
            }
        }

        for(int i=0;i<4;i++){
            tmp = Math.max(dp[land.length-1][i],tmp);
        }
        answer =tmp;

        return answer;
    }
}
