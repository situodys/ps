package ps.프로그래머스.lv2;

import java.util.*;
import java.lang.*;
/*
1시간
21카카오블라인드

주문에 대해 오름차순 정렬.
해당 주문으로 만들 수 있는 모든 조합과 등장 횟수 map에 저장.
course는 주문가지수를 나타냄(2가지 메뉴, 3가지 메뉴 등).
모든 조합에 대해 length()로 몇가지 메뉴인지 확인하고 각 가짓수마다 최대값 구함
등장 횟수 <2  && 최대값과 일치 경우 list에 담고 반환

타풀이=> pq이용
 */

public class 메뉴_리뉴얼 {

    public static Map<String,Integer> comb = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        int maxCourse = course[course.length-1];

        for(int i=0;i<orders.length;i++){
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            makeCombination(new String(tmp),course);
        }

        //for(String k : comb.keySet())
        //System.out.println(k+ comb.get(k));

        int[] maxLenSet = new int[maxCourse+1];
        ArrayList<String> arr = new ArrayList<>();

        Set<String> keySet = comb.keySet();
        for(String key : keySet){
            int kLen = key.length();
            int keyVal = comb.get(key);
            maxLenSet[kLen] =Math.max(maxLenSet[kLen],keyVal);
        }

        for(String key : keySet){
            int kLen = key.length();
            int keyVal = comb.get(key);
            if(maxLenSet[kLen]<2) continue;
            if(maxLenSet[kLen]==keyVal)
                arr.add(key);
        }

        answer = new String[arr.size()];
        arr.sort(Comparator.naturalOrder());
        for(int i=0;i<arr.size();i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }

    public void makeCombination(String order,int[] course){
        for(int i=0;i<course.length;i++){
            if(order.length()<course[i]) break;
            StringBuilder sb = new StringBuilder();
            dfs(0,0,sb,order,course[i]);
        }
    }

    public void dfs(int cnt, int idx, StringBuilder sb, String order, int len){
        if(cnt==len){
            String str = sb.toString();
            comb.put(str, comb.getOrDefault(str, 0)+1);
            return;
        }
        for(int i=idx; i<order.length();i++){
            sb.append(order.charAt(i));
            dfs(cnt+1,i+1,sb,order,len);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
