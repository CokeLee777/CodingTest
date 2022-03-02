package programmers;

import java.util.HashMap;
import java.util.Map;

public class NewsClustering {

    public static int solution(String str1, String str2) {
        //빈 문자열이 하나라도 포함되었다면
        if(str1.length() == 0 || str2.length() == 0) return 0;
        //소문자로 모두 치환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int totalSet = 0;
        //str1 집합 찾기
        Map<String, Integer> map1 = new HashMap<>();
        for(int i = 0; i < str1.length()-1; i++){
            //문자가 아닌것이 있다면 무시
            if(!Character.isLetter(str1.charAt(i)) || !Character.isLetter(str1.charAt(i+1)))
                continue;
            //아니라면 집합에 추가
            map1.put(str1.substring(i, i+2), map1.getOrDefault(str1.substring(i, i+2), 0) + 1);
            totalSet++;
        }

        //str2 집합 찾기
        Map<String, Integer> map2 = new HashMap<>();
        for(int i = 0; i < str2.length()-1; i++){
            //문자가 아닌것이 있다면 무시
            if(!Character.isLetter(str2.charAt(i)) || !Character.isLetter(str2.charAt(i+1)))
                continue;
            //아니라면 집합에 추가
            map2.put(str2.substring(i, i+2), map2.getOrDefault(str2.substring(i, i+2), 0) + 1);
            totalSet++;
        }

        //둘다 공집합이라면
        if(map1.isEmpty() && map2.isEmpty()) return 65536;
        //아니라면 교집합의 개수를 찾는다
        int commonSet = 0;
        for (String key : map2.keySet()) {
            if(map1.containsKey(key)){
                commonSet += Math.min(map1.get(key), map2.get(key));
            }
        }
        return (commonSet * 65536) / (totalSet - commonSet);
    }
}
