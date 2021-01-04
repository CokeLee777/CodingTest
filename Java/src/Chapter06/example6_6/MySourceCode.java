package Chapter06.example6_6;

public class MySourceCode {

    public static int[] arr = new int[]{7,5,9,0,3,1,6,2,9,1,4,8,0,5,2};

    public static int[] check = new int[10];

    public static void main(String[] args) {

        for(int data: arr){
            check[data]++;
        }

        for(int i = 0; i < check.length; i++){
            for(int j = 0; j < check[i]; j++){
                System.out.print(i + " ");
            }
        }

    }

}

