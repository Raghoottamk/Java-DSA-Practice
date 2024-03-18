import java.util.*;
class Q7_binary_subarrays_with_sum {
//https://leetcode.com/problems/binary-subarrays-with-sum/description/
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int sum = 0;
            int cnt = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0,1);
            for(int i = 0 ; i < nums.length ; i++){
                sum += nums[i];
                int rem = sum - goal;
                if(map.containsKey(rem)){
                    cnt += map.get(rem);
                }
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
            return cnt;
        }
    }
}