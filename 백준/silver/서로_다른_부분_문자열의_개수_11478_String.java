package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 서로_다른_부분_문자열의_개수_11478_String {
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

        String x = br.readLine();

        Set<String> g = new HashSet<>();

        for(int i=0; i<x.length();i++){
            StringBuilder sb = new StringBuilder();
            sb.append(x.charAt(i));
            if (!g.contains(sb.toString())) {
                g.add(sb.toString());
            }
            for(int j=i+1; j<x.length();j++){
                sb.append(x.charAt(j));
                if (!g.contains(sb.toString())) {
                    g.add(sb.toString());
                }
            }
        }

        System.out.println(g.size());
    }
}
