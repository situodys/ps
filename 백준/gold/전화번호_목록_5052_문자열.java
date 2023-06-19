package ps.백준.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 전화번호_목록_5052_문자열 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int n, m, t;
    public static int[][] arr;
    public static int[][] orders;
    public static int[] tmp;
    public static boolean[] visited;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while(t-->0){
            n = Integer.parseInt(br.readLine());
            Set<String> sets = new HashSet<>();
            List<String> lists = new ArrayList<>();

            boolean isDup=false;
            for(int i=0; i<n;i++){
                String x = br.readLine();
                lists.add(x);
                sets.add(x);
            }

            for(int i=0; i<n;i++){
                String cur = lists.get(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < cur.length(); j++) {
                    sb.append(cur.charAt(j));
                    if (sets.contains(sb.toString()) && !sb.toString().equals(cur)) {
                        isDup=true;
                        break;
                    }
                }
                if(isDup)break;
            }
            if (isDup) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
