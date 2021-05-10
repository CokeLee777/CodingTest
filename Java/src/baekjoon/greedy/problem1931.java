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
        //시작시간이 낮은 것부터 정렬
        if(this.start < time.start){
            return -1;
        } else if(this.start == time.start) {
            //시작시간이 같으면 회의시간이 낮은 것 부터 정렬
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
        int maxCnt = 0;

        for(int i = 0; i < n; i++){
            //첫 회의 시간
            Time time = list.get(i);
            //회의가 끝나는 시간
            int endTime = time.getEnd();
            //현재 회의의 개수
            int nowCnt = 1;

            for(int j = i+1; j < n; j++){
                //끝나는 시간 뒤에 회의시간 찾기
                if(list.get(j).getStart() >= endTime){
                    endTime = list.get(j).getEnd();
                    nowCnt += 1;
                }
            }

            maxCnt = Math.max(maxCnt, nowCnt);
        }

        System.out.println(maxCnt);

    }
}
