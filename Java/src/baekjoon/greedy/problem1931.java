package baekjoon.greedy;

import java.util.*;

class Time implements Comparable<Time>{

    private int start;
    private int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getSub(){
        return end - start;
    }

    @Override
    public int compareTo(Time time) {
        //회의 시간이 적은 회의부터 정렬
        if(this.start < time.start){
            return -1;
        } else if(this.start == time.start){
            //회의 시작시간이 적은 회의부터 정렬
            if(this.getSub() < time.getSub()) return -1;
            else return 1;
        } else {
            return 1;
        }
    }
}

/**
 * https://www.acmicpc.net/problem/1931
 * 수정중
 */
public class problem1931 {

    public static int n;
    public static ArrayList<Time> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //회의의 개수 입력받기
        n = sc.nextInt();

        //회의 시간들 입력받기
        for(int i = 0; i < n; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Time(start, end));
        }
        //설정한 대로 정렬
        Collections.sort(list);
        //회의의 최대개수
        int result = 0;
        int startTime = -1;
        int endTime = 0;

        for(int i = 0; i < n; i++){
            //회의 시간
            Time time = list.get(i);
            startTime = time.getStart();
            endTime = time.getEnd();
            int cnt = 1;

            for(int j = i+1; j < n; j++){
                if(list.get(j).getStart() < endTime) continue;

                endTime = list.get(j).getEnd();
                cnt += 1;
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);

    }
}
