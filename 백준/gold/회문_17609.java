package ps.백준.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회문_17609 {
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[] dx = new int[]{ -1, 1,0, 0};
    public static int n,m,t;
    public static int[][] board;
    public static int[][] visited;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String target = br.readLine();
            int len =target.length();
            int left=0; int right= len-1;
            boolean isEnd=false;
            while(left<right){
                if (target.charAt(left) == target.charAt(right)) {
                    left++;
                    right--;
                    continue;
                }
                else{
                    if (left + 1 <= right) {
                        String tmp = target.substring(left + 1, right+1);
                        if (isPalindrome(tmp)) {
                            System.out.println(1);
                            isEnd=true;
                            break;
                        }
                    }
                    if(left<right-1){
                        String tmp = target.substring(left, right);
                        if (isPalindrome(tmp)) {
                            System.out.println(1);
                            isEnd=true;
                            break;
                        }
                    }
                    if (!isEnd) {
                        System.out.println(2);
                        isEnd=true;
                        break;
                    }
                }
            }
            if (!isEnd) {
                System.out.println(0);
            }
        }

        System.out.println();
    }

    private static boolean isPalindrome(String tmp) {
        int len = tmp.length();
        for (int i = 0; i < len / 2; i++) {
            if (tmp.charAt(i) != tmp.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
