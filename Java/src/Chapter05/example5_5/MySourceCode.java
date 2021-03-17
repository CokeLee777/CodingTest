package Chapter05.example5_5;

public class MySourceCode {
    //반복적으로 구현한 팩토리얼 함수
    public static int factorial1(int n){
        int result = 1;

        for(int i = 1; i <= n; i++){
            result *= i;
        }

        return result;
    }

    //재귀적으로 구현한 팩토리얼 함수
    public static int factorial2(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial2(n-1);
    }

    public static void main(String[] args){

        System.out.println("반복적으로 구현: " + factorial1(5));
        System.out.println("재귀적으로 구현: " + factorial2(5));
    }
}
