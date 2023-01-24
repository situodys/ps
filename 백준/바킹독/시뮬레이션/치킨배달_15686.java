package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달_15686 {
    public static int n,m;
    public static int[][] board;
    public static boolean[] visited;
    public static int answer =Integer.MAX_VALUE;
    public static List<Loc> chicken = new ArrayList<>();
    public static List<Loc> house = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1){
                    house.add(new Loc(i, j));
                }
                if(board[i][j]==2){
                    chicken.add(new Loc(i,j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        comb(0, 0);

        System.out.println(answer);
    }

    public static void comb(int cnt, int idx){
        if(cnt==m){
            calDistanceSum();
            return;
        }

        for(int i=idx; i<chicken.size();i++){
            if(visited[i]) continue;
            visited[i] =true;
            comb(cnt+1,i);
            visited[i]=false;
        }
    }

    public static void calDistanceSum() {
        int[] dist = new int[house.size()];
        int distSum=0;
        Arrays.fill(dist,200);
        for(int i=0 ;i<visited.length;i++){
            if(!visited[i]) continue;
            Loc cur = chicken.get(i);
            calDist(dist,cur);
        }
        for(int i=0;i<dist.length;i++){
            distSum+=dist[i];
        }
        answer = Math.min(answer, distSum);
    }

    public static void calDist(int[] distArr, Loc chickenLoc) {
        for(int i=0; i< house.size();i++){
            Loc houseLoc = house.get(i);
            distArr[i] = Math.min(distArr[i],
                    Math.abs(chickenLoc.y - houseLoc.y) +
                            Math.abs(chickenLoc.x - houseLoc.x)
            );
        }
    }

    static class Loc{
        private int y;
        private int x;

        public Loc(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
