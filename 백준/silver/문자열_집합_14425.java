package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 문자열_집합_14425 {

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

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<String,Integer> strings = new HashMap<>();

        for(int i=0; i<n;i++){
            String row = br.readLine();
            strings.put(row, 1);
        }

        int cnt=0;

        for(int i=0; i<m;i++){
            String x = br.readLine();
            if(strings.get(x)==null) continue;
            cnt++;
        }
        System.out.println(cnt);
    }
}
