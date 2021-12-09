package Chapter11.problem29;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //집의 개수와 공유기의 개수 입력받기
        int n = sc.nextInt();
        int c = sc.nextInt();

        //집 좌표 정보 입력받기
        List<Integer> houses = new ArrayList<>();
        for(int i = 0; i < n; i++){
            houses.add(sc.nextInt());
        }

        //집 좌표 정렬
        Collections.sort(houses);

        int start = 1;                              //가능한 최소거리
        int end = houses.get(n-1) - houses.get(0);  //가능한 최대거리
        int result = 0;

        while(start <= end){
            //mid : 가장 인접한 공유기 사이의 거리를 임의로 설정
            int mid = (start + end) / 2;
            //첫째 집에는 무조건 공유기를 설치한다고 가정
            int now = houses.get(0);        //현재 공유기를 설치한 집 인덱스
            //설치한 공유기 개수
            int cnt = 1;
            //현재의 mid 값을 이용하여 공유기 설치 -> 첫번째 집을 제외한 공유기 설치
            for(int i = 1; i < n; i++){
                //현재 정해놓은 공유기 사이의 거리에 부합한다면
                if(houses.get(i) >= now + mid){
                    now = houses.get(i);
                    cnt += 1;
                }
            }
            //c개 이상의 공유기를 설치할 수 있을 경우 거리 증가
            if(cnt >= c){
                start = mid  + 1;   //가능한 최소 거리 증가
                result = mid;       //가장 인접한 공유기 사이의 거리를 결과값에 담아둠
            } else {
                end = mid - 1;      //가능한 최대 거리 감소
            }

        }

        System.out.println("result = " + result);

    }
}
