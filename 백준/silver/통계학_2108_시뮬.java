package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 통계학_2108_시뮬 {
    public static int n, m, p;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static boolean[][] visited;
    public static char[][] board;
    public static boolean[] keys;
    public static List<int[]>[] locationsOfWall;
    public static int answer = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int[] count = new int[8001];

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<t;i++){
            int x = Integer.parseInt(br.readLine());
            count[x+4000]++;
            arr.add(x);
        }

        int sum = arr.stream()
                .mapToInt(Integer::valueOf)
                .sum();
        arr.sort(Comparator.naturalOrder());

        double avg = Math.round((double)sum / t);
        int mid = arr.get(arr.size() / 2);

        List<Integer> tmp = new ArrayList<>();
        int maxValue=-1;
        for(int i=0; i<=8000; i++){
            if (maxValue < count[i]) {
                maxValue = count[i];
            }
        }

        for(int i=0; i<=8000; i++){
            if (count[i] == maxValue) {
                tmp.add(i-4000);
            }
        }

        tmp.sort(Comparator.naturalOrder());
        int mostOccurredValue = tmp.size() >= 2 ? tmp.get(1) : tmp.get(0);

        int diff = arr.get(arr.size() - 1) - arr.get(0);

        System.out.println((int)avg);
        System.out.println(mid);
        System.out.println(mostOccurredValue);
        System.out.println(diff);
    }
}
