package programmers;

import java.util.*;

public class MenuRenewer {

    private static Map<String, Integer> courseToCount;

    private static void combination(String str, StringBuilder temp, int courseLen, int left){
        //코스의 길이만큼의 조합을 구했다면 카운트 증가
        if(temp.length() == courseLen){
            courseToCount.put(temp.toString(), courseToCount.getOrDefault(temp.toString(), 0) + 1);
            return;
        }
        //조합 구하기
        for(int i = left; i < str.length(); i++){
            temp.append(str.charAt(i));
            combination(str, temp, courseLen, i+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static List<String> solution(String[] orders, int[] course) {

        //주문들 다 오름차순으로 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
        //course 길이만큼 반복하여 필요한 조합을 구한다
        List<String> renewers = new ArrayList<>();
        for(int i = 0; i < course.length; i++){
            //현재 코스길이에 대한 조합의 수를 map을 사용하여 카운트
            courseToCount = new HashMap<>();
            //가장 많이 주문된 횟수를 저장하기 위한 변수
            int max = Integer.MIN_VALUE;
            //주문들의 조합을 구한다
            for(int j = 0; j < orders.length; j++){
                StringBuilder temp = new StringBuilder();
                //코스의 총 요리 개수 <= 각 주문의 길이인 경우 조합
                if(course[i] <= orders[j].length())
                    combination(orders[j], temp, course[i], 0);
            }

            //가장 많이 주문된 횟수를 초기화
            for (Integer count : courseToCount.values()) {
                max = Math.max(count, max);
            }
            //최소 2번이상 주문되고, max만큼 주문되었다면 모두 결과값에 삽입
            for (String key : courseToCount.keySet()) {
                if(max >= 2 && courseToCount.get(key) == max)
                    renewers.add(key);
            }
        }

        //결과값을 오름차순으로 정렬
        Collections.sort(renewers);

        return renewers;
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"};
        int[] course = {2,3,4};

        solution(orders,course);
    }
}
