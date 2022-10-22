package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {

    /*
    10:13~10:35
    */
    public static Map<String, Integer> scores = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        initScores();

        for(int i=0;i<survey.length;i++){
            calScores(survey[i],choices[i]);
        }

        answer =makeAnswer();
        return answer;
    }

    public void initScores(){
        scores.put("R",0); scores.put("T",0);
        scores.put("C",0); scores.put("F",0);
        scores.put("J",0); scores.put("M",0);
        scores.put("A",0); scores.put("N",0);
    }

    public void calScores(String question, int choice){
        String[] splited = question.split("");
        if(choice <=3){
            scores.put(splited[0],scores.get(splited[0])+4-choice);
            return;
        }
        if(choice==4)
            return;
        scores.put(splited[1],scores.get(splited[1])+choice-4);
    }

    public String makeAnswer(){
        StringBuilder sb = new StringBuilder();
        sb.append(scores.get("R") < scores.get("T") ? "T":"R");
        sb.append(scores.get("C") < scores.get("F") ? "F":"C");
        sb.append(scores.get("J") < scores.get("M") ? "M":"J");
        sb.append(scores.get("A") < scores.get("N") ? "N":"A");
        return sb.toString();
    }
}
