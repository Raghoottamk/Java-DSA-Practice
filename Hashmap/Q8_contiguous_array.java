import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/contiguous-array/description/
public class Q8_contiguous_array {
    class Solution {
    public int findMaxLength(int[] nums) {
        int ones = 0,zeroes = 0,maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == 0) zeroes++;
            else ones++;
            int diff = zeroes - ones;
            if(diff == 0){
                maxLen = Math.max(maxLen,i+1);
            }
            if(map.containsKey(diff)){
                maxLen = Math.max(maxLen,i - map.get(diff));
            }else{
                map.put(diff,i);
            }
        }
        return maxLen;
    }
}
}
