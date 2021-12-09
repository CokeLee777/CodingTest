package Chapter11.problem29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MySourceCode {

    public static int n, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        c = sc.nextInt();

        List<Integer> home = new ArrayList<>();
        for(int i = 0; i < n; i++){
            home.add(sc.nextInt());
        }

        //집 번호 순서대로 정렬
        Collections.sort(home);

        int start = 1;                          //처음에 가능한 최소거리를 1로 셋팅
        int end = home.get(n-1) - home.get(0);  //처음에 가능한 최대거리를 가장 먼 집들간의 거리로 셋팅
        int result = 0;

        //최소거리가 최대거리를 넘지않을 때 까지 반복
        while(start <= end){

            int mid = (start + end) / 2;    //공유기를 설치 할 간격을 중간값으로 설정

            int now = home.get(0);          //공유기를 첫번째 집에는 설치한다고 가정
            int cnt = 1;

            //첫번째 집 이외에 공유기 간격을 지키는 곳에 공유기 설치
            for(int i = 1; i < n; i++){
                if(home.get(i) >= now + mid){
                    now = home.get(i);
                    cnt += 1;
                }
            }

            //공유기를 c개이상 설치할 수 있다면 공유기 설치하는 간격을 늘리고 결과값을 저장
            if(cnt >= c){
                start = mid + 1;
                result = mid;
            }
            //c개이상 설치할 수 없다면 공유기를 설치하는 간격을 줄인다.
            else {
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}
