package baekjoon.greedy;

import java.io.*;
import java.util.Stack;

public class Problem2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //숫자의 길이와 지울 문자의 길이 입력받기
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String s = br.readLine();

        //숫자 비교
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char x = s.charAt(i);
            //스택에 아무것도 존재하지 않는다면 삽입
            if(stack.isEmpty()) {
                stack.push(x);
                continue;
            }
            //아니라면 스택 포인터와 숫자비교
            //현재 값이 스택포인터의 값보다 크다면
            while(!stack.isEmpty() && stack.peek() < x && k > 0){
                stack.pop();
                k--;
            }
            stack.push(x);
        }

        StringBuilder ans = new StringBuilder();

        while(!stack.isEmpty()){
            Character x = stack.pop();
            if(k != 0) {
                k--;
                continue;
            }
            //지울 숫자가 남지 않았다면
            ans.insert(0, x);
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}
