package ps.프로그래머스.lv2;

import java.util.*;

public class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        Arrays.sort(data,(int[] a,int[] b)->{
            if(a[col-1]==b[col-1]){
                return b[0]-a[0];
            }
            return a[col-1]-b[col-1];
        });

        List<Integer> tmp = new ArrayList<>();


        for(int i= row_begin-1; i<row_end;i++){
            int remain = 0;
            for(int j=0; j<data[i].length;j++){
                remain+=data[i][j]%(i+1);
            }
            // System.out.println(i+". "+remain);
            tmp.add(remain);
        }

        int init=tmp.get(0);
        for(int i=1; i<tmp.size();i++){
            init ^=tmp.get(i);
        }

        return init;
    }
}
