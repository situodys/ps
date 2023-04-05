package ps.백준.바킹독.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리_순회_22856 {
    public static int n, r, q;
    public static int dy[] = {0, 0, -1, 1};
    public static int dx[] = {-1, 1, 0, 0};
    public static int left[];
    public static int right[];
    public static int cnt=0;
    public static int end;
    public static boolean visited[];
    public static boolean isEnd= false;

    public static StringBuilder sb = new StringBuilder();
    private static long answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        left = new int[n + 1];
        right = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            st  = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            left[cur]=l;
            right[cur]=r;
        }
        end=1;
        while (right[end] != -1) {
            end = right[end];
        }
        inOrder(1);
        System.out.println(answer);
    }

    private static void inOrder(int root) {
        visited[root]=true;

        if(left[root]!=-1){
            if(isEnd) return;
            answer ++;
            inOrder(left[root]);
        }
        if(right[root]!=-1 ){
            if(isEnd) return;
            answer ++;
            inOrder(right[root]);
        }
        if(isEnd) return;
        if(root==end){
            isEnd = true;
            return;
        }
        answer++;
    }
}
