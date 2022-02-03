package algorithm.array;

public class ExistStudent {
    public Integer mySourceCode(Integer[] nums){
        Integer answer = 0;

        Integer max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                answer++;
                max = nums[i];
            }
        }

        return answer;
    }
}
