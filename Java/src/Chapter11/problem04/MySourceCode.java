package Chapter11.problem04;

import java.util.*;

public class MySourceCode {

    public static int n;    //동전의 갯수
    public static List<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //동전의 갯수 입력받기
        n = sc.nextInt();
        //동전 입력받기
        for(int i = 0; i < n; i++){
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);    //동전들 크기순으로 정렬

        int target = 1;
        for(int i = 0; i < n; i++){
            //만들 수 없는 금액을 찾았을 때 반복 종료
            if(target < arrayList.get(i)) break;
            target += arrayList.get(i);
        }
    }
}
