package ps.백준.바킹독.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자_카드_10815 {
    public static int n, m, k;
    public static int dy[] = {0, 0, -1, 1, 1, 1, -1, -1};
    public static int dx[] = {1, -1, 0, 0, 1, -1, 1, -1};
    public static int dz[] = {0, 0, 0, 0, 1, -1};
    public static int[] myCards;
    public static int[] targets;
    public static int[] tmp;
    public static int[] compact;
    public static long answer = 0;
    public static int MAX_VAlUE = 10000;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        myCards = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n;i++){
            myCards[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());

        targets = new int[m];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m;i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(myCards);

        for(int i=0; i<m;i++){
            int x = targets[i];
            if (hasTarget(x)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static boolean hasTarget(int x) {
        int lo =-1; int hi=myCards.length;

        while(lo+1 <hi){
            int mid = (lo+hi)/2;
            if (myCards[mid] == x) {
                return true;
            }
            else if(myCards[mid]<=x){
                lo=mid;
            }
            else hi=mid;
        }
        return false;
    }
}
