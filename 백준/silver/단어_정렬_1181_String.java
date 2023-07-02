package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 단어_정렬_1181_String {
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{ 0,-1, 0, 1};
    public static int n, m, t;
    public static int[][] board;
    public static boolean[][]visited;
    public static int answer;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        List<String> arr = new ArrayList<>();

        for(int i=0; i<n;i++){
            String x =br.readLine();
            arr.add(x);
        }

        List<String> ans = arr.stream()
                .distinct()
                .sorted((s1, s2) -> {
                    if (s1.length() == s2.length()) {
                        return s1.compareTo(s2);
                    }
                    return s1.length() - s2.length();
                })
                .collect(Collectors.toUnmodifiableList());

        StringBuilder sb = new StringBuilder();
        for (String an : ans) {
            sb.append(an).append("\n");
        }
        System.out.println(sb);
    }
}
