package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 듣보잡_1764_set {
    public static int n, m, p;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int answer = 0;
    public static int[][] board;
    public static int[][] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for(int i=0; i<n;i++){
            String x = br.readLine();
            set.add(x);
        }
        List<String> ans = new ArrayList<>();

        for(int i=0; i<m;i++){
            String x = br.readLine();
            if (set.contains(x)) {
                answer++;
                ans.add(x);
            }
        }
        ans.sort(Comparator.naturalOrder());

        System.out.println(answer);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
