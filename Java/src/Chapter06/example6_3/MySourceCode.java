package Chapter06.example6_3;

public class MySourceCode {

    public static int[] data = new int[]{7,5,9,0,3,1,6,2,4,8};

    public static void main(String[] args){

        for(int i = 1; i < data.length; i++){
            for(int j = i; j > 0; j--){
                if(data[j] < data[j-1]){
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
                else{
                    break;
                }
            }
        }

        for(int d: data){
            System.out.print(d + " ");
        }
    }
}
