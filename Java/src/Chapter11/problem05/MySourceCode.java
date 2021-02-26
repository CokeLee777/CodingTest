package Chapter11.problem05;

import java.util.*;

public class MySourceCode {

    public static int n, m; //볼링공의 갯수, 공의 최대무게
    public static List<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //볼링공의 갯수, 공의 최대무게 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        //각 번호의 공의 무게 입력받기
        for(int i = 0; i < n; i++){
            arrayList.add(sc.nextInt());
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                //공의 무게가 같으면 경우의 수를 세지 않음
                if(arrayList.get(i).equals(arrayList.get(j))) continue;
                else result++;
            }
        }

        System.out.println("result = " + result);
    }
}
