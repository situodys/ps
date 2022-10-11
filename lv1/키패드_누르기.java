package programmers.lv1;
import java.util.*;
import java.lang.*;

public class 키패드_누르기 {

    public String solution(int[] numbers, String hand) {
        String answer = "";

        Map<Integer,Location> info = new HashMap<>();

        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(3*i+j ==10){
                    info.put(0,new Location(i,j));
                    continue;
                }
                info.put(3*i+j+1,new Location(i,j));
            }
        }

        Location left = info.get(10);
        Location right = info.get(12);
        Location cur;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<numbers.length;i++){
            cur = info.get(numbers[i]);
            if(numbers[i]== 1|| numbers[i]==4||numbers[i]==7){
                left = info.get(numbers[i]);
                sb.append('L');
                continue;
            }
            if(numbers[i]== 3|| numbers[i]==6||numbers[i]==9){
                right = info.get(numbers[i]);
                sb.append('R');
                continue;
            }

            if(left.dist(cur) < right.dist(cur)){
                left = info.get(numbers[i]);
                sb.append('L');
                continue;
            }
            else if(left.dist(cur) > right.dist(cur)){
                right = info.get(numbers[i]);
                sb.append('R');
                continue;
            }
            else{
                if(hand.equals("right")){
                    right = info.get(numbers[i]);
                    sb.append('R');
                }else{
                    left = info.get(numbers[i]);
                    sb.append('L');
                }
            }

        }

        answer = sb.toString();

        return answer;
    }

    class Location {
        public int y;
        public int x;
        public Location(int y, int x){
            this.y=y;
            this.x=x;
        }

        public int dist(Location loc){
            return Math.abs(loc.y-this.y)+Math.abs(loc.x-this.x);
        }

    }
}
