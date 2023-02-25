package ps.백준.바킹독.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 주식_11501 {

    public static int n,t,stockCount=0;
    public static long answer;
    public static int[] stockPrices;
    public static Map<Integer, Integer> mp;

    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            answer=0;
            stockCount=0;
            mp = new HashMap<>();
            n = Integer.parseInt(br.readLine());
            stockPrices = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                stockPrices[i] = Integer.parseInt(st.nextToken());
                mp.put(stockPrices[i], mp.getOrDefault(stockPrices[i], 0)+1);
            }

            List<Integer> sortedKeys = new ArrayList<>(mp.keySet());
            sortedKeys.sort(Comparator.reverseOrder());
            int loc =0;
            int curMax=0;

            for (int i = 0; i < n; i++) {
                curMax = sortedKeys.get(loc);
                if (stockPrices[i] < curMax && (i != n-1)) {
                    stockCount++;
                    answer -= stockPrices[i];
                    mp.put(stockPrices[i],mp.get(stockPrices[i])-1);
                    continue;
                }
                if (stockPrices[i] == curMax) {
                    answer += curMax * stockCount;
                    mp.put(curMax,mp.get(curMax)-1);
                    loc = updateMaxLoc(loc,sortedKeys);
                    stockCount=0;
                    continue;
                }
            }
            bw.write(answer + "\n");

        }
        bw.flush();
        bw.close();
    }

    public static int updateMaxLoc(int prevLoc,List<Integer> sortedKeys) {
        int loc = prevLoc;
        while (loc<mp.size()) {
            if (mp.get(sortedKeys.get(loc)) == 0) {
                loc++;
                continue;
            }
            break;
        }
        return loc;
    }
}
