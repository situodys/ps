package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기_설치_2110_R {

    public static int n,c;
    public static int[] houses;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    private static int answer= Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int start = 0, end = houses[n - 1] - houses[0]+1;

        while (start + 1 < end) {
            int mid = (start+end)/2;

            if (canSetRouter(mid)) {
                answer = mid;
                start= mid;
            }else{
                end =mid;
            }
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
    }

    private static boolean canSetRouter(int dist) {
        int latestRouterLocation = 0;
        int routerHouseCount=1;
        for (int i = 1; i < n; i++) {
            int latestDist = houses[i] - houses[latestRouterLocation];
            if (latestDist >= dist) {
                latestRouterLocation = i;
                routerHouseCount++;
            }
        }
        return routerHouseCount >=c;
    }
}
