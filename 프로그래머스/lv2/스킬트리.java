package ps.프로그래머스.lv2;
import java.util.*;

public class 스킬트리 {
    //22:06~22:37
    public static ArrayList<Character> skillSet = new ArrayList<>();
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0;i<skill.length();i++){
            skillSet.add(skill.charAt(i));
        }

        for(int i=0;i<skill_trees.length;i++){
            if(isSatisfiedCondition(skill_trees[i],skill)){
                answer++;
            }
            System.out.println();
        }
        return answer;
    }

    public boolean isSatisfiedCondition(String st, String sk){
        int len = st.length();
        char cur;
        int curIdx=0;

        Set<Character> appearedSkill = new HashSet<>();

        for(int i=0;i<len;i++){
            cur =st.charAt(i);
            if(!skillSet.contains(cur)){
                continue;
            }
            if(appearedSkill.contains(cur)){
                continue;
            }
            if(skillSet.get(curIdx)==cur){
                appearedSkill.add(cur);
                curIdx++;
                continue;
            }
            return false;
        }
        return true;

    }
}
