package Chapter11.problem06;

import java.util.*;

class Food implements Comparable<Food>{

    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return time;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Food food) {
        if(this.time < food.time) return -1;
        else return 1;
    }
}

public class Solution {

    public int solution(int[] food_times, long k){
        //전체 음식을 먹는 시간보다 k가 크거나 같다면
        long sum = 0;
        for(int i = 0; i < food_times.length; i++){
            sum += food_times[i];
        }
        if(sum <= k) return -1;

        //시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용한다.
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for(int i = 0; i < food_times.length; i++){
            //음식시간 음식번호 삽입
            pq.offer(new Food(food_times[i], i + 1));
        }

        sum = 0;                            //먹기 위해 사용한 시간
        long previous = 0;                  //직전에 다 먹은 음식 시간
        long length = food_times.length;    //남은 음식의 갯수

        //sum + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
        while(sum + ((pq.peek().getTime() - previous) * length) <= k){
            int now = pq.poll().getTime();
            sum += (now - previous) * length;   //먹기 위해 사용한 시간 셋팅
            length -= 1;                        //다 먹은 음식 제외하기
            previous = now;                     //이전 음식 시간 설정
        }

        //남은 음식 중 몇 번째 음식인지 확인하여 출력
        List<Food> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }

        //음식의 번호 기준으로 정렬
        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.getIndex(), b.getIndex());
            }
        });
        return result.get((int) ((k - sum) % length)).getIndex();
    }
}
