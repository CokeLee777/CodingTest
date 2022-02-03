package algorithm.array;

public class RockScissorsPaper {

    public Character[] mySourceCode(int[][] nums){
        Character[] results = new Character[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(Math.abs(nums[i][0] - nums[i][1]) == 1){
                results[i] = nums[i][0] > nums[i][1] ? 'A' : 'B';
            } else if (nums[i][0] == nums[i][1]){
                results[i] = 'D';
            } else {
                results[i] = nums[i][0] > nums[i][1] ? 'B' : 'A';
            }
        }
        return results;
    }
}
