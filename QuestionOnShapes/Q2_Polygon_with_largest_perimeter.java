package QuestionOnShapes;

//https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
import java.util.Arrays;

public class Q2_Polygon_with_largest_perimeter {
class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for(int num : nums) sum += num;
        for(int i = nums.length - 1; i >= 2 ; i--){
            if(sum - nums[i] > nums[i]) return sum;

            sum -= nums[i];
        }
        return -1;
    }
}
}
