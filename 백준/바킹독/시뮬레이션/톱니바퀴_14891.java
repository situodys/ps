package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 톱니바퀴_14891 {

    public static int n, m;
    public static int[] score = {1, 2, 4, 8};
    public static List<List<Integer>> topnees = new ArrayList<>();
    public static boolean[][] visited = new boolean[12][6];
    public static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            List<Integer> topnee = br.readLine().chars()
                    .boxed()
                    .map(cur->cur-48)
                    .collect(Collectors.toCollection(LinkedList::new));
            topnees.add(topnee);
        }

        n = Integer.parseInt(br.readLine());
        int topneeIdx=0;
        int rotDir=0;
        StringTokenizer st;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            topneeIdx = Integer.parseInt(st.nextToken())-1;
            rotDir = Integer.parseInt(st.nextToken());

            rotate(topneeIdx, rotDir);
            toLeft(topneeIdx,rotDir);
            toRight(topneeIdx,rotDir);
        }

        for(int i=0 ;i< 4; i++){
            if (topnees.get(i).get(0) == 1) {
                answer += score[i];
            }
        }
        System.out.println(answer);

    }

    private static void toLeft(int idx, int dir) {
        if(idx==0) return;
        List<Integer> cur = topnees.get(idx);
        int curTarget = dir==1? cur.get(7):cur.get(5);
        int tmp= topnees.get(idx - 1).get(2);
        if (tmp != curTarget) {
            rotate(idx - 1, dir == 1 ? -1 : 1);
            toLeft(idx-1,dir == 1 ? -1 : 1);
        }

    }

    public static void rotate(int idx, int dir) {
        List<Integer> cur = topnees.get(idx);
        if (dir == 1) {
            //시계
            int last = cur.get(7);
            cur.remove(7);
            cur.add(0, last);
        }
        if (dir == -1) {
            int first = cur.get(0);
            cur.add(first);
            cur.remove(0);
        }
    }

    private static void toRight(int idx, int dir) {
        if(idx==3) return;
        List<Integer> cur = topnees.get(idx);
        int curTarget = dir == 1 ? cur.get(3) : cur.get(1);
        int tmp= topnees.get(idx+1).get(6);
        if (tmp != curTarget) {
            rotate(idx + 1, dir == 1 ? -1 : 1);
            toRight(idx + 1, dir == 1 ? -1 : 1);
        }
    }
}
