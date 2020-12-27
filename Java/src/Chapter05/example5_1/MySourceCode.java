package Chapter05.example5_1;

import java.util.*;

public class MySourceCode {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();


        while(!stack.empty()){
            System.out.println(stack.peek());   //제일 최상단의 스택을 확인한다.
            stack.pop();                        //제일 최상단의 스택을 꺼낸다.
        }
    }
}
