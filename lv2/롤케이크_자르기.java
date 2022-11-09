package programmers.lv2;

import java.util.Stack;

public class 롤케이크_자르기 {
    //14:36~15:20
    /*처음 시도에는 배열을 자르고 잘린 두 배열을 Stream을 이용해 Set변환해
    개수를 비교하는 방식으로 진행했으나 타임아웃
    한쪽에 몰아두고 반대쪽에 추가하는 방법으로 통과했다.
    * */
    public static int[] broKinds = new int[10001];
    public static int[] sisKinds = new int[10001];
    public static int broCnt=0;
    public static int sisCnt=0;

    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;

        Stack<Integer> bro = new Stack<>();

        for(int i=0;i<len;i++){
            bro.push(topping[i]);
            if(broKinds[topping[i]]==0){
                broCnt++;
            }
            broKinds[topping[i]]++;
        }

        while(bro.size() > 1){
            int cur = bro.pop();
            sisKinds[cur]++;
            broKinds[cur]--;
            if(sisKinds[cur]==1){
                sisCnt++;
            }
            if(broKinds[cur]==0)
                broCnt--;
            if(sisCnt==broCnt)
                answer++;
        }
        return answer;
    }

    public void print(int[] arr){

        for(int a : arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
