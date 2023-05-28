package ps.백준.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호_만들기_1759 {
    public static int n, m, k;
    public static int dy[] = {0, 0, -1, 1, 1, 1, -1, -1};
    public static int dx[] = {1, -1, 0, 0, 1, -1, 1, -1};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static long answer = 0;
    public static char[][] board;
    public static char[] moes = new char[]{'a', 'e', 'i', 'o', 'u'};
    public static char[] alps;
    public static boolean[] visited;
    public static char[] tmp;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        alps = new char[m];
        visited = new boolean[m];
        tmp= new char[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m;i++){
            alps[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alps);

        dfs(0,0,0,0);
    }

    private static void dfs(int mo,int ja,int cur,int start){
        if (mo + ja == n) {
            if(mo<1 || ja<2) return;
            sb = new StringBuilder();
            for (char c : tmp) {
                sb.append(c);
            }
            System.out.println(sb);
            return;
        }
        if(cur>=n) return;

        for(int i=start; i<m;i++){
            if(visited[i]) continue;
            visited[i]=true;
            tmp[cur] = alps[i];
            if (isMo(alps[i])) {
                dfs(mo + 1, ja, cur+1,i + 1);
            }else{
                dfs(mo,ja+1,cur+1,i+1);
            }
            visited[i]=false;
        }
    }

    private static boolean isMo(char x) {
        for (char mo : moes) {
            if(mo==x) return true;
        }
        return false;
    }
}
