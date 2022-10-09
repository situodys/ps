package programmers.lv2;
import java.util.*;

public class 방문길이 {

    /*
    한쪽 방향으로 이동했더라도 반대방향으로 이동한 것 또한
    기록으로 남겨놔야한다.
     */
    public int solution(String dirs) {
        int answer = 0;


        ArrayList<ArrayList<Set<Character>>> visited = new ArrayList<>();
        for(int i=0;i<11;i++){
            visited.add(new ArrayList<Set<Character>>());
            for(int j=0;j<11;j++){
                visited.get(i).add(new HashSet<Character>());
            }
        }
        Queue<Character> q = new LinkedList<>();

        for(int i=0;i<dirs.length();i++){
            q.offer(dirs.charAt(i));
        }

        int curY=5;
        int curX =5;
        Character dir;
        Character op;

        while(!q.isEmpty()){
            dir = q.poll();
            int ny, nx;
            if(dir=='U'){
                ny = curY-1;
                nx= curX;
                op = 'D';
            }
            else if(dir=='D'){
                ny=curY+1;
                nx=curX;
                op = 'U';
            }
            else if(dir=='R'){
                ny=curY;
                nx = curX+1;
                op = 'L';
            }
            else{
                ny=curY;
                nx=curX-1;
                op = 'R';
            }

            if(ny<0 || nx<0 || ny>=11 || nx>=11) continue;
            if(!visited.get(ny).get(nx).contains(dir)) {
                visited.get(ny).get(nx).add(dir);
                visited.get(curY).get(curX).add(op);
                answer++;
            }
            curY=ny; curX=nx;
        }
        return answer;
    }
}
