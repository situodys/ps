package ps.백준.바킹독.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 잃어버린_괄호_1541 {

    public static int n,answer=0;
    public static int[] dp;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        boolean isMinus = false;

        StringTokenizer st = new StringTokenizer(input, "+-", true);

        while (st.hasMoreTokens()) {
            String tk = st.nextToken();
            if(tk.equals("+"))continue;
            if (tk.equals("-")) {
                isMinus = true;
            }
            else{
                if (isMinus) {
                    answer -= Integer.parseInt(tk);
                }
                else{
                    answer += Integer.parseInt(tk);
                }
            }
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }
}
