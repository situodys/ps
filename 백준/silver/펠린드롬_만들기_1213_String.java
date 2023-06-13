package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 펠린드롬_만들기_1213_String {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{ -1, 1,0, 0};
    public static int n,m,t;
    public static char[][] board;
    public static int[][] visited;
    public static int answer=0;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();

        Map<Character,Integer> mps = new HashMap<>();

        for (char lo = 'A'; lo <= 'Z'; lo++) {
            mps.put(lo, 0);
        }

        for(int i=0; i<target.length();i++){
            mps.put(target.charAt(i), mps.get(target.charAt(i)) + 1);
        }

        int oddCnt=0;
        char oddKey='a';
        for (Character key : mps.keySet()) {
            if (mps.get(key) % 2 == 1) {
                oddCnt++;
                oddKey=key;
            }
        }
        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        Deque<Character> dq = new ArrayDeque<>();
        if (oddCnt != 0) {
            dq.add(oddKey);
        }

        for (char i = 'Z'; i >= 'A'; i--) {
            if(i==oddKey && mps.get(i)==0) continue;
            if(mps.get(i)==0) continue;
            for(int j=0; j<mps.get(i)/2;j++){
                dq.offerFirst(i);
                dq.offerLast(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : dq) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
