package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트_18111_시뮬 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int n, m, t;
    public static int[][] board;
    public static int[][] visited;
    public static int answerOfTime = Integer.MAX_VALUE;
    public static int answerOfHeight = 0;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        int maxHeight=0;
        int minHeight=0;

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > maxHeight) {
                    maxHeight=board[i][j];
                }
                if (board[i][j] < minHeight) {
                    minHeight=board[i][j];
                }

            }
        }

        int lo=minHeight-1;
        int hi = maxHeight+1;

        for(int i=minHeight; i<=maxHeight;i++){
            int time = check(i);
            if(time>=0){
                if (answerOfTime >= time) {
                    if (answerOfTime == time) {
                        answerOfHeight = Math.max(i,answerOfHeight);
                        continue;
                    }
                    answerOfTime=time;
                    answerOfHeight = i;
                }
            }

        }

        System.out.println(answerOfTime+" "+answerOfHeight);
    }

    public static int check(int x) {
        int time=0;
        int leftBlocks=t;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur=board[i][j]-x;
                if(cur==0) continue;
                else if(cur>0){
                    leftBlocks+=cur;
                    time+=cur*2;
                }else{
                    cur *= -1;
                    leftBlocks-=cur;
                    time+=cur;
                }
            }
        }
        if (leftBlocks < 0) {
            return -1;
        }
        return time;
    }
}
