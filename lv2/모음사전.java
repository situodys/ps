package programmers.lv2;

public class 모음사전 {

    public static int cnt;
    public static int answer=0;
    public static String word;
    public static char[] chs = new char[]{'A','E','I','O','U'};

    public int solution(String tmp) {

        word =tmp;
        StringBuilder sb = new StringBuilder();

        dfs(0,sb);
        return answer;
    }

    public void dfs(int cur,StringBuilder sb){
        if(cur>5) {
            cnt--;
            return;
        }

        if(sb.length() == word.length()){
            if(sb.toString().equals(word)){
                answer = cnt;
                return;
            }
        }
        for(int i=0;i<5;i++){
            cnt++;
            dfs(cur+1,sb.append(chs[i]));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
