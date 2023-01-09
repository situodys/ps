package programmers.lv1;

public class 옹알이_2 {
    public static int answer = 0;
    public int solution(String[] babbling) {

        for(int i=0; i<babbling.length;i++){
            if(dfs(babbling[i],0,0))
                answer++;
        }

        return answer;
    }

    public boolean dfs(String s, int cur, int last){
        int idx=cur;
        if(s.length()==cur)
            return true;
        if(cur !=0 && s.charAt(cur)==s.charAt(last))
            return false;
        if(s.charAt(idx)=='a'){
            if(idx+3 <= s.length() && s.substring(idx,idx+3).equals("aya")){
                return dfs(s,idx+3,idx);
            }
            return false;
        }
        if(s.charAt(idx)=='y'){
            if(idx+2 <= s.length() && s.substring(idx,idx+2).equals("ye")){
                return dfs(s,idx+2,idx);
            }
            return false;
        }
        if(s.charAt(idx)=='w'){
            if(idx+3 <= s.length() && s.substring(idx,idx+3).equals("woo")){
                return dfs(s,idx+3,idx);
            }
            return false;
        }
        if(s.charAt(idx)=='m'){
            if(idx+2 <= s.length() && s.substring(idx,idx+2).equals("ma")){
                return dfs(s,idx+2,idx);
            }
            return false;
        }
        return false;
    }
}
