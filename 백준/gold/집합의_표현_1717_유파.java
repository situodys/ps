package ps.백준.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의_표현_1717_유파 {
    public static int n, m, a, b, c;
    public static int dy[] = {0, 0, -1, 1, 0, 0};
    public static int dx[] = {1, -1, 0, 0, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[] dist;
    public static int[] parents;
    public static int answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];

        for(int i=0; i<=n;i++){
            parents[i]=i;
        }

        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (oper == 0) {
                merge(a, b);
                continue;
            }
            else{
                boolean isUnion = isUnion(a, b);
                if (isUnion) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }

        System.out.println(sb);
    }

    private static void merge(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA < parentB) {
            parents[parentB] = parentA;
        }
        else parents[parentA]= parentB;
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static boolean isUnion(int a, int b) {
        return find(a) == find(b);
    }
}
