package Chapter08.example8_2;

public class MySourceCode {

    //한번 계산된 결과를 메모이제이션 하기 위한 리스트 초기화
    public static int[] arr = new int[100];

    public static int fibo(int x){
        //1과 2의 피보나치 수열은 1이므로 1반환
        if(x == 1 || x == 2) return 1;
        //계산되었다면 그 값을 반환
        if(arr[x] != 0) return arr[x];

        arr[x] = fibo(x - 1) + fibo(x - 2);

        return arr[x];

    }

    public static void main(String[] args) {
        System.out.println(fibo(7));
    }

}

