package ps.프로그래머스.lv3;

public class 스티커_모으기_2 {

    public int solution(int sticker[]) {
        if(sticker.length==1) return sticker[0];

        int firstStartDp[] = new int[sticker.length];
        int secondStartDp[] = new int[sticker.length];

        firstStartDp[0]= sticker[0];
        firstStartDp[1]= sticker[0];
        secondStartDp[1]= sticker[1];

        for(int i=2; i<sticker.length-1;i++){
            firstStartDp[i]= Math.max(firstStartDp[i-1],firstStartDp[i-2]+sticker[i]);
        }

        for(int i=2; i<sticker.length;i++){
            secondStartDp[i]= Math.max(secondStartDp[i-1],secondStartDp[i-2]+sticker[i]);
        }

        return Math.max(firstStartDp[sticker.length-2],secondStartDp[sticker.length-1]);
    }
}
