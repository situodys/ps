package ps.프로그래머스.lv2;

import java.util.ArrayList;

public class _2개_이하로_다른_비트 {
    /*
    * 처음에 xor 연산으로 시도했으나 마지막 2개 테스트케이스에서 타임아웃
    * 최하위 비트에서 0발견하는 방식으로 접근해서 0일 경우 1로 바꾸고
    * 0이없는 경우 최상위 비트1 => 10으로 바꿔줬으나 전체 테케 실패
    * 검색해서 0발견할 때 하위 비트 바꿔주면 더 작은값이 나올 수있음을 확인,, 후 정답*/
    public long[] solution(long[] numbers) {
        long[] answer = {};
        ArrayList<Long> ans = new ArrayList<>();

        for (long target : numbers) {
            ans.add(result(target));
        }

        answer = new long[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public long result(long start) {
        String l2b = Long.toBinaryString(start);
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (int i = l2b.length() - 1; i >= 0; i--) {
            if (flag) {
                sb.append(l2b.charAt(i));
                continue;
            }
            if (l2b.charAt(i) == '0') {
                flag = true;
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append('0');
                }
                sb.append('1');
                continue;
            }
            sb.append('1');
        }
        if (flag) return Long.parseLong(sb.reverse().toString(), 2);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("01");
        return Long.parseLong(sb.reverse().toString(), 2);
    }
}
