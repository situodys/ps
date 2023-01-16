package ps.프로그래머스.lv2;

import java.util.*;
import java.lang.*;

/*
* 12:19 - 13:16
* bfs로 푸는게 맞는 듯,,
* */

public class 거리두기_확인하기 {
    public static Queue<Tester> q;

    public int[] solution(String[][] places) {
        int[] answer = {};
        ArrayList<Integer> tmp = new ArrayList<>();

        for(int i=0;i<places.length;i++){
            tmp.add(checkDistance(places[i]));
        }

        answer = new int[places.length];
        for(int i=0;i<tmp.size();i++){
            answer[i]=tmp.get(i);
        }

        return answer;
    }

    public int checkDistance(String[] map){
        q = new LinkedList<Tester>();
        char[][] room=new char[5][5];
        for(int i=0;i<5;i++){
            room[i]=map[i].toCharArray();
            for(int j=0;j<5;j++){
                if(room[i][j]=='P')
                    q.offer(new Tester(i,j));
            }
        }

        while(!q.isEmpty()){
            Tester cur = q.poll();

            for(Tester other : q){
                if(cur.distanceFrom(other)>2) continue;
                if(cur.isSatisfiedRoleWith(other,room)==0)
                    return 0;
            }
        }
        return 1;
    }
    class Tester{
        int y;
        int x;

        public Tester(int y, int x){
            this.y=y;
            this.x=x;
        }

        public int distanceFrom(Tester t){
            return Math.abs(t.y-this.y)+Math.abs(t.x-this.x);
        }

        public int isSatisfiedRoleWith(Tester other, char[][] room) {
            if (this.x == other.x) {
                if (this.y + 1 == other.y) return 0;
                if (room[this.y + 1][this.x] == 'O')
                    return 0;
            } else if (this.y == other.y) {
                if (this.x + 1 == other.x) return 0;
                if (room[this.y][this.x + 1] == 'O')
                    return 0;
            } else if (this.y < other.y) {
                if (this.x < other.x) {
                    if (room[this.y][this.x + 1] == 'O' || room[this.y + 1][this.x] == 'O')
                        return 0;
                } else {
                    if (room[this.y][this.x - 1] == 'O' || room[this.y + 1][this.x] == 'O')
                        return 0;
                }
            }
            return 1;
        }
    }
}
