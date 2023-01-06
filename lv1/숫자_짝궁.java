package programmers.lv1;

public class 숫자_짝궁 {
    public static int[] xInfo = new int[10];
    public static int[] yInfo = new int[10];
    public static int[] answerInfo = new int[10];

    public String solution(String X, String Y) {
        String answer = "";

        for(int i=0; i<X.length();i++){
            xInfo[X.charAt(i)-'0']++;
        }

        for(int i=0; i<Y.length();i++){
            yInfo[Y.charAt(i)-'0']++;
        }

        for(int i=0 ;i<10;i++){
            answerInfo[i] = Math.min(xInfo[i],yInfo[i]);
        }

        if(isNoMatch()) return "-1";
        if(isZero()) return "0";

        return makeAnswer();
    }

    public boolean isNoMatch(){
        for(int i=0;i<10;i++){
            if(answerInfo[i]==0) continue;
            return false;
        }
        return true;
    }

    public boolean isZero(){
        for(int i=1;i<10;i++){
            if(answerInfo[i]==0) continue;
            return false;
        }
        return true;
    }

    public String makeAnswer(){
        StringBuilder sb = new StringBuilder();

        for(int i=9;i>=0;i--){
            for(int j=0;j<answerInfo[i];j++){
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
