package Chapter03.example3_1;

public class MySolution {
    public static void main(String[] args){
        int n = 1260;                               //거슬러 줘야 할 돈
        int result = 0;                             //거슬러 줘야 할 동전의 최소 개수 초기화
        int[] coins = new int[]{500, 100, 50, 10};  //거스름돈 종류 모두 배열에 담기

        for(int coin: coins){
            result += n / coin;                     //각 동전으로 거슬러 줄 수 있는 동전 개수 count
            n %= coin;                              //거슬러주고 남은 돈 다시 n에 반환
        }

        System.out.println(result);
    }
}
