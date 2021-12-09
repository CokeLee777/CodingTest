package programmers;

import java.util.*;

class Stone{

    private int index;
    private int restCount;

    public Stone(int index, int restCount) {
        this.index = index;
        this.restCount = restCount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getRestCount() {
        return restCount;
    }

    public void setRestCount(int restCount) {
        this.restCount = restCount;
    }
}

public class PassStones {

    public static final int INF = (int)1e9;
    public static List<Integer> stoneList = new ArrayList<>();

    public static int solution(int[] stones, int k) {
        int answer = 0;

        for (int i = 0; i < stones.length; i++) {
            stoneList.add(stones[i]);
        }

        stoneList.add(INF); //건넌 후 장소는 항상 건널 수 있다.

        while(true){
            int gap = 1;
            for(int i = 0; i < stoneList.size(); i++){
                if(gap > k) return answer;
                //징검다리 중 밟을 수 없는 다리가 있다면
                if(stoneList.get(i) <= 0) gap += 1;
                else gap = 1;
            }

            stoneList.replaceAll(i -> i-1);
            answer++;
        }
    }

    public static void main(String[] args) {

        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};

        int answer = solution(stones, 3);

        System.out.println("answer = " + answer);
    }
}
