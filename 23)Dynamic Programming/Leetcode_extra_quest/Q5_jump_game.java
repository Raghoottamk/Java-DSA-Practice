import java.util.Arrays;

public class Q5_jump_game {
    //recursion
    class Solution {
        public boolean canJump(int[] nums) {
            return solve(0, nums);
        }
        private boolean solve(int n,int[] nums){
            if(n == nums.length-1) return true;
            //if(n >= nums.length) return false;
            if(nums[n] == 0) return false;//test case [0,1] ouput false,cnat jump anywhere
        
            //jumps possible 1 -> val of nums[i]
            //but jumps should be in terms of index....
            for(int i = 1; i <= nums[n] ; i++){
                if(i < nums.length && solve(n+i,nums)){//to avoid index out of bounds error
                    return true;
                }
            }
            return false;
        }
    }
    //memoization
    class Solution2 {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);  // Initialize dp array with -1
        return solve(nums, 0, dp);
    }

    private boolean solve(int[] nums, int idx, int[] dp) {
        if (idx == nums.length - 1) {
            return true;
        }
        if (nums[idx] == 0) {
            return false;
        }

        if (dp[idx] != -1) {
            if(dp[idx] == 1) return true;
            return false;  // Reuse memoized result
        }

        int reach = idx + nums[idx];
        for (int jump = idx + 1; jump <= reach; jump++) {
            if (jump < nums.length && solve(nums, jump, dp)) {
                dp[idx] = 1;
                return true;  // Memoize result for idx
            }
        }
        dp[idx] = 0;
        return false;  // Memoize result for idx
    }
}
}