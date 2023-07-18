package ps.백준.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 패션왕_신해빈_9375_해시 {
    public static int n, m, p;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {1, -1, 0, 0};
    public static int answer = 0;
    public static int[][] board;
    public static int[][] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            n = Integer.parseInt(br.readLine());
            Map<String, Integer> mp = new HashMap<>();
            for(int i=0; i<n;i++){
                String[] split = br.readLine().split(" ");
                if (mp.containsKey(split[1])) {
                    mp.put(split[1], mp.get(split[1]) + 1);
                }else{
                    mp.put(split[1], 2);
                }
            }
            int result=1;
            for (Integer value : mp.values()) {
                result*=value;
            }
            System.out.println(result-1);
        }
    }
}
