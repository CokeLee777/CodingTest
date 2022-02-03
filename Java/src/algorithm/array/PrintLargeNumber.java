package algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class PrintLargeNumber {
    public Integer[] mySourceCode(Integer[] nums){
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i-1 >= 0 && nums[i-1] > nums[i]) continue;
            results.add(nums[i]);
        }

        return results.toArray(new Integer[results.size()]);
    }
}
