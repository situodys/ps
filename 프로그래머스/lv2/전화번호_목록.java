package ps.프로그래머스.lv2;
import java.util.*;

public class 전화번호_목록 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> st = new TreeSet<>();

        for(int i=0;i<phone_book.length;i++){
            st.add(phone_book[i]);
        }

        Iterator<String> it = st.iterator();
        String cur;
        String next;

        cur = it.next();

        while(it.hasNext()){
            next = it.next();
            if(next.startsWith(cur)){
                answer=false;
                break;
            }
            cur=next;
        }

        return answer;
    }
}
