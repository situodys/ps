package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 민서의_응급_수슬_20955 {


    public static int n, m;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int parents[];
    public static int cycleCnt;

    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for(int i=0;i<=n;i++){
            parents[i]=i;
        }
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (isUnion(from, to)) {
                cycleCnt++;
            }
            union(from, to);
        }

        HashSet<Integer> cnt = new HashSet<>();
        for (int i = 1; i <=n; i++) {
            if (!cnt.contains(find(parents[i]))) {
                cnt.add(find(parents[i]));
            }
        }

        System.out.println(cycleCnt+ cnt.size()-1);
    }

    private static boolean isUnion(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        }
        return false;
    }

    private static void union(int a,int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
    }

    private static int find(int x) {
        if(x==parents[x]) return x;
        return parents[x]=find(parents[x]);
    }
}
