package ps.프로그래머스.lv3;

import java.util.*;

public class 자물쇠와_열쇠 {
    public static int n;
    public static int m;
    public static int[][] board;
    public static Queue<int[]> q;
    public static int[] std;
    public boolean solution(int[][] key, int[][] lock) {
        n= key.length;
        m=lock.length;
        board =key;
        boolean answer = false;
        q = new LinkedList<>();

        boolean isAllBump=true;
        for(int i=0; i<lock.length;i++){
            for(int j=0; j<lock[0].length;j++){
                if(lock[i][j]==0){
                    isAllBump=false;
                    q.offer(new int[]{i,j});
                }
            }
        }
        if(isAllBump) return true;
        std = q.poll();
        q.offer(new int[]{0,0});
        for(int i=0; i<q.size()-1;i++){
            int[] cur = q.poll();
            cur[0]-=std[0];
            cur[1]-=std[1];
            q.offer(cur);
        }
        int dir=0;

        while(dir <4){
            if(canUnlock(lock)){
                answer=true;
                break;
            }
            rotate();
            dir++;
        }

        return answer;
    }
    private boolean canUnlock(int[][] lock){
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    if(isKey(i,j)){
                        if(isFit(i,j,lock)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isFit(int y, int x, int[][] lock){
        boolean tmp =true;
        int cnt=0;
        int idx=0;
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                int ny = i+std[0]-y;
                int nx = j+std[1]-x;
                if(ny<0 || ny>=m || nx<0 ||nx>=m)continue;
                idx++;
                if((lock[ny][nx] ^ board[i][j]) == 0) {
                    // System.out.println((lock[ny][nx] ^ board[i][j])+ " "+ny+" "+nx+" "+i+" "+j);
                    tmp=false;
                    cnt++;
                }
            }
        }
        if(idx==cnt) return true;
        return tmp;
    }

    private boolean isKey(int y, int x){
        Queue<int[]> tmp = new LinkedList<>(q);
        while(!tmp.isEmpty()){
            int[] cur= tmp.poll();
            int ny = cur[0]+y;
            int nx = cur[1]+x;
            if(ny<0 || ny>=n || nx<0 || nx>=n) return false;
            if(board[ny][nx] ==0 )return false;
        }
        return true;
    }
    private void rotate(){
        int[][] tmp = new int[n][n];
        for(int i=0; i<n;i++){
            for(int j=0 ;j<n;j++){
                tmp[i][j]= board[n-1-j][i];
            }
        }
        board =tmp;
    }
}
