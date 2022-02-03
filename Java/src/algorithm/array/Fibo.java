package algorithm.array;

public class Fibo {

    public int[] mySourceCode(int n){
        int[] fibo = new int[n+1];
        fibo[1] = 1; fibo[2] = 1;

        for(int i = 3; i <= n; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        return fibo;
    }
}
