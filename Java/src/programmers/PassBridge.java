package programmers;

public class PassBridge {

    public static class MySourceCode{

        public static int solution(int[] stones, int k) {
            int answer = 0;

            int jump = 1;
            int idx = -1;
            while(jump <= k){
                if(idx + jump < stones.length && stones[idx + jump] == 0) {
                    jump++;
                    continue;
                }

                if(idx >= 0) stones[idx]--;
                idx += jump;
                jump = 1;

                if(idx >= stones.length){
                    answer++;
                    idx = -1;
                    jump = 1;
                }
            }

            return answer;
        }

        public static void main(String[] args) {
            int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
            solution(stones, 3);
        }
    }
}
