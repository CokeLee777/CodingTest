package Chapter11.problem33;

import java.util.*;

class Plan{
    private int time;
    private int pay;

    public Plan(int time, int pay) {
        this.time = time;
        this.pay = pay;
    }

    public int getTime() {
        return time;
    }

    public int getPay() {
        return pay;
    }
}

/**
 * 수정중
 */
public class MySourceCode {

    public static List<Plan> plans = new ArrayList<>();
    public static int n, t, p;
    public static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //상담 일정이 잡힌 날의 개수
        n = sc.nextInt();
        d = new int[n];
        //상담 일정표 입력받기
        for(int i = 0; i < n; i++){
            t = sc.nextInt();
            p = sc.nextInt();
            plans.add(new Plan(t, p));
        }

        //다이나믹 프로그래밍 수행
        for(int i = 0; i < n; i++){
            int nowDate = i;
            //i일에 상담을 무조건 진행한다고 가정
            //만약 퇴사하고 난 다음까지 상담이 진행된다면 무시
            if(i + plans.get(i).getTime() - 1 > n) continue;
            else {
                d[i] += plans.get(i).getPay();
                nowDate += plans.get(i).getTime();
            }


        }

    }
}
