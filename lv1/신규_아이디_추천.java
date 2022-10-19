package programmers.lv1;

public class 신규_아이디_추천 {
    /*
    9:23~ 9:52
    */
    public static String solution(String new_id) {
        String answer = "";

        answer = new_id;
        answer = answer.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9-._]","");

        StringBuilder sb = new StringBuilder();
        boolean flag=false;
        for(int i=0;i<answer.length();i++){
            if(answer.charAt(i)=='.'){
                if(flag ==false){
                    flag=true;
                    sb.append(answer.charAt(i));
                }
                continue;
            }
            sb.append(answer.charAt(i));
            flag=false;
        }

        if(sb.length() != 0 && sb.charAt(0)=='.'){
            sb.deleteCharAt(0);
        }
        if(sb.length() != 0 && sb.charAt(sb.length()-1) =='.'){
            sb.deleteCharAt(sb.length()-1);
        }

        if(sb.length()==0){
            sb.append("a");
        }
        if(sb.length()>=16){
            for(int i=sb.length()-1;i>=15;i--){
                sb.deleteCharAt(i);
            }
            if(sb.charAt(sb.length()-1)=='.')
                sb.deleteCharAt(sb.length()-1);
        }
        while(sb.length()<=2){
            sb.append(sb.charAt(sb.length()-1));
        }
        System.out.println(sb.toString());
        answer= sb.toString();
        return answer;
    }
}

/*
* public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}",".");
        temp = temp.replaceAll("^[.]|[.]$","");
        System.out.println(temp.length());
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }*/