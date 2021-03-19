package Chapter06.example6_3;

public class MySourceCode {

    public static int[] arr = {7,5,9,0,3,1,6,2,4,8};

    public static void main(String[] args) {

        for(int i = 1; i < arr.length; i++){
            int swap_index = i;
            for(int j = i-1; j >= 0; j--){
                //앞 숫자가 더 크면 자리 바꿈
                if(arr[j] > arr[swap_index]){
                    int temp = arr[swap_index];
                    arr[swap_index] = arr[j];
                    arr[j] = temp;
                    swap_index = j;
                }
            }
        }

        for(int a: arr){
            System.out.print(a + " ");
        }
    }
}
