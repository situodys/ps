package programmers.lv2;
import java.util.*;
public class 괄호_회전하기 {
    public int solution(String s) {

        int answer=0;
        int n =s.length();

        Stack<Character> st = new Stack<>();
        s += s;
        char target;

        for(int k=0;k<n;k++){
            st =  new Stack<>();
            boolean flag=false;
            for(int i=0;i<n;i++){
                target = s.charAt(k+i);
                if(target =='(' || target=='{' || target=='['){
                    st.push(target);
                    flag=true;
                    continue;
                }
                if(st.empty()) {
                    flag=false;
                    break;
                }

                if(target==')' && st.peek() =='('){
                    st.pop();
                }
                else if(target=='}' && st.peek() =='{'){
                    st.pop();
                }
                else if(target==']' && st.peek() =='['){
                    st.pop();
                }
            }
            if(flag && st.empty()) {
                answer++;
            }
        }
        return answer;
    }
}
