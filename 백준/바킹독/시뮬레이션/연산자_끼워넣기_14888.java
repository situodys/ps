package ps.백준.바킹독.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class 연산자_끼워넣기_14888 {
    public static int n;
    public static int[] operatorCount = new int[4];
    public static int[] operand;
    public static int operatorTotalCount=0;
    public static int minAnswer =Integer.MAX_VALUE ;
    public static int maxAnswer =Integer.MIN_VALUE ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        operand = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<n;i++){
            operand[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<4;i++){
            operatorCount[i] = Integer.valueOf(st.nextToken());
            operatorTotalCount += operatorCount[i];
        }

        dfs(1,operand[0]);
        System.out.println(maxAnswer+"\n"+minAnswer);
    }

    public static void dfs(int cnt, int curValue) {
        if (n == cnt) {
            minAnswer = Math.min(minAnswer, curValue);
            maxAnswer = Math.max(maxAnswer, curValue);
            return;
        }

        for(int i=0 ;i<4; i++){
            if(operatorCount[i]==0) continue;
            operatorCount[i]--;
            dfs(cnt + 1, oper(curValue, i, operand[cnt]));
            operatorCount[i]++;
        }

    }

    private static int oper(int curValue, int idx, int operand) {
        return Oper.cal(curValue,idx, operand);
    }

    public  enum Oper {
        PLUS(0,(a,b)->a+b),
        MINUS(1,(a,b)->a-b),
        MULTIPLY(2,(a,b)->a*b),
        DIVIDE(3,(a,b)->a/b);

        private static final Map<Integer, Oper> opers = new HashMap<>();
        static {
            Oper[] values = Oper.values();
            for (int i = 0; i < 4; i++) {
                opers.put(i, values[i]);
            }
        }

        private final int index;
        private final BiFunction<Integer,Integer,Integer> calculate;

        Oper(int index, BiFunction<Integer,Integer, Integer> calculate) {
            this.index = index;
            this.calculate = calculate;
        }

        public static int cal(int a, int idx,int b) {
            return opers.get(idx).calculate.apply(a, b);
        }
    }
}
