package ps.프로그래머스.lv2;

public class 타겟넘버 {

    public static int len;
    public static int tar;
    public static int answer;
    public static int[] arr;
    public int solution(int[] numbers, int target) {
        answer = 0;

        len = numbers.length;
        tar =target;
        arr =numbers;

        dfs(0,0);

        return answer;
    }

    public void dfs(int n, int cnt){
        if(cnt==len){
            if(n==tar)
                answer++;
            return;
        }

        dfs(n+arr[cnt],cnt+1);
        dfs(n-arr[cnt],cnt+1);
    }

}
