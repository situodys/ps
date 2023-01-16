package ps.프로그래머스.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수식_최대화 {
    //40분??
    public static String[] caseList = new String[]{"+-*","+*-","-*+","-+*","*+-","*-+"};

    public long solution(String expression) {
        long answer = 0;
        List<String> parsed = new ArrayList<>();

        parseExpression(parsed,expression);

        for(int cases =0; cases<6; cases++){
            List<String> storage = new ArrayList<>(parsed);
            List<String> afterOperation = new ArrayList<>();

            for(int i=0;i<3;i++){
                String currentOp = String.valueOf(caseList[cases].charAt(i));

                for(int j=0;j<storage.size();j++){
                    String cur = storage.get(j);
                    if(cur.equals(currentOp)){
                        String op1 = afterOperation.get(afterOperation.size()-1);
                        String op2 = storage.get(j+1);

                        afterOperation.remove(afterOperation.size()-1);

                        afterOperation.add(calculate(op1,cur,op2));
                        j++;
                        continue;
                    }
                    afterOperation.add(cur);
                }
                storage = new ArrayList<>(afterOperation);
                afterOperation = new ArrayList<>();
            }
            answer = Math.max(answer,Math.abs(Long.parseLong(storage.get(0))));
        }

        return answer;
    }

    public void parseExpression(List<String> storage,String expression){
        StringTokenizer st = new StringTokenizer(expression,"+-*",true);

        while(st.hasMoreTokens()){
            storage.add(st.nextToken());
        }
    }

    public String calculate(String op1, String operator, String op2){
        long opd1 = Long.parseLong(op1);
        long opd2 = Long.parseLong(op2);

        if(operator.equals("+")){
            return String.valueOf(opd1+opd2);
        }
        if(operator.equals("-")){
            return String.valueOf(opd1-opd2);
        }
        return String.valueOf(opd1*opd2);
    }
}
