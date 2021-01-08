package Chapter08.example8_4;

public class MySourceCode {

    public static int[] arr = new int[100];

    public static void main(String[] args) {
        arr[1] = 1;
        arr[2] = 1;

        //보텀업 다이나믹 프로그래밍
        for(int i = 3; i < arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[3]);
    }

}
