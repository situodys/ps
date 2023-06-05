package ps.백준.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class AC_5430_문자열 {
    public static int n, m, t;
    public static int dy[] = {0, 1, 0, -1}; //, 1, 1, -1, -1
    public static int dx[] = {-1, 0, 1, 0}; //, 1, -1, 1, -1
    public static int dz[] = {0, 0, 0, 0, 1, -1};

    public static int answer = 0;
    public static int[][] board;
    public static int[][] orders;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    //11:00
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            String orders = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String origin = br.readLine();
            sb = new StringBuilder(origin);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
            int[] arr=null;
            if (sb.length() == 0) {
                arr = new int[]{};
            }
            else{
                arr= Arrays.stream(sb.toString().replaceAll(",", " ").split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            Deque<Integer> dq = new ArrayDeque();
            for(int i=0; i<arr.length;i++){
                dq.add(arr[i]);
            }

            boolean isInOrder = true;
            boolean isError = false;
            for (int i = 0; i < orders.length(); i++) {
                char cur = orders.charAt(i);
                if (cur == 'R') {
                    isInOrder = !isInOrder;
                } else {
                    if (dq.size() == 0) {
                        isError = true;
                        break;
                    }
                    if (isInOrder) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringJoiner sj = new StringJoiner(",", "[", "]");
                if (isInOrder) {
                    while (!dq.isEmpty()) {
                        sj.add(Integer.toString(dq.pollFirst()));
                    }
                }
                else{
                    while (!dq.isEmpty()) {
                        sj.add(Integer.toString(dq.pollLast()));
                    }
                }
                System.out.println(sj);
            }
        }
    }
}
