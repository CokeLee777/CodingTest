package leetcode.greedy;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static class MySourceCode{

        public static int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int maxArea = 0;

            while(left < right){
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
                if(height[left] < height[right]) left++;
                else right--;
            }

            return maxArea;
        }
    }
}
