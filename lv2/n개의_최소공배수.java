package programmers.lv2;

public class n개의_최소공배수 {
    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i=1; i<arr.length;i++){
            int gcdV = gcd(answer,arr[i]);
            answer = answer * arr[i] /gcdV;
        }
        return answer;
    }

    public int gcd(int l, int r){
        int maxV = Math.max(l,r);
        int minV = Math.min(l,r);

        while(maxV % minV != 0){
            int tmp = maxV%minV;
            maxV = minV;
            minV = tmp;
        }
        return minV;
    }
}
