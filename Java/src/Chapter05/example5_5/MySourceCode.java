package Chapter05.example5_5;

public class MySourceCode {
    public static int result = 1;

    public int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args){
        MySourceCode mySourceCode = new MySourceCode();

        System.out.println(mySourceCode.factorial(5));
    }
}
