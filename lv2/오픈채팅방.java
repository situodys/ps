package programmers.lv2;
import java.util.*;

public class 오픈채팅방 {

    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String,String> info = new HashMap<>();
        String[] splited;
        ArrayList<String[]> arr = new ArrayList<>();
        ArrayList<String> msgs = new ArrayList<>();

        for(int i=0;i<record.length;i++){
            splited = record[i].split(" ");
            if(splited.length != 2)
                info.put(splited[1],splited[2]);
            arr.add(new String[]{splited[0],splited[1]});
        }

        String[] order;
        String msg;
        for(int i=0;i<arr.size();i++){
            order =arr.get(i);
            if(order[0].equals("Enter")){
                msg = info.get(order[1]) + "님이 들어왔습니다.";
                msgs.add(msg);
                continue;
            }
            if(order[0].equals("Leave")){
                msg = info.get(order[1]) + "님이 나갔습니다.";
                msgs.add(msg);
                continue;
            }
        }

        answer = new String[msgs.size()];
        for(int i=0;i<msgs.size();i++){
            answer[i]= msgs.get(i);
        }

        return answer;
    }

}
