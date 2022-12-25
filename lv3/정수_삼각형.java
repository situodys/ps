package programmers.lv3;

public class 정수_삼각형 {
    public static int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;

        init(triangle);

        for(int i=2; i<triangle.length;i++){
            for(int j=1; j<triangle[i].length-1; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + triangle[i][j];
            }
        }

        for(int i=0; i<triangle.length;i++){
            answer = Math.max(dp[triangle.length-1][i], answer);
        }

        return answer;
    }

    public void init(int[][] triangle){
        dp = new int[triangle.length][];

        for(int i=0; i<triangle.length;i++){
            dp[i] = new int[i+1];
        }

        dp[0][0]=triangle[0][0];
        for(int i=1; i<triangle.length;i++){
            dp[i][0] = dp[i-1][0]+triangle[i][0];
            dp[i][i]= dp[i-1][i-1] + triangle[i][i];
        }
    }
}
