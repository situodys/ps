package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 멀티버스2_18869 {

    public static int n,c;
    public static int[][] planets;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        planets = new int[n][c];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                planets[i][j] = Integer.parseInt(st.nextToken());
            }
            calculateOrder(planets[i]);
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(isPair(planets[i], planets[j])) answer++;
            }
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }

    private static void calculateOrder(int[] planet) {
        List<Integer> uniq= new ArrayList<>();

        for (int val : planet) {
            uniq.add(val);
        }

        uniq = uniq.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        for (int i = 0; i < planet.length; i++) {
            planet[i] = lowerBound(uniq, planet[i]);
        }
    }

    private static int lowerBound(List<Integer> uniq, int x) {
        int st = -1, en = uniq.size();

        while (st + 1 < en) {
            int mid  = (st+en)/2;
            if (uniq.get(mid) < x) {
                st = mid;
            }
            else{
                en = mid;
            }
        }
        return st;
    }

    private static boolean isPair(int[] planet, int[] planet1) {
        for (int i = 0; i < c; i++) {
            if (planet[i] != planet1[i]) {
                return false;
            }
        }
        return true;
    }
}
