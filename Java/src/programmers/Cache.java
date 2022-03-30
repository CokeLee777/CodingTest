package programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {

    public int solution(int cacheSize, String[] cities) {

        //모든 도시이름 소문자로 변환
        List<String> cityList = Arrays.stream(cities)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        //도시들 LRU 방식으로 처리
        int totalTime = 0;
        Deque<String> deque = new LinkedList<>();
        for(String city: cityList){
            //cache hit라면
            if(!deque.isEmpty() && deque.contains(city)){
                deque.remove(city);
                deque.offerFirst(city);
                totalTime++;
                continue;
            }

            //cache miss라면
            deque.offerFirst(city);
            if(deque.size() > cacheSize){
                deque.pollLast();
            }

            totalTime += 5;
        }

        return totalTime;
    }
}
