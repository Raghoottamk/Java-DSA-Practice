import java.util.Arrays;
/*
https://leetcode.com/problems/house-robber/description/
 */
public class Q6_house_rober1 {
    //memoization
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,nums.length - 1, dp);
    }
    private int solve(int[] nums,int i,int[] dp){
        if(i == 0) return nums[i];
        if(i < 0) return 0;
        if(dp[i] != -1) return dp[i];
        
        int pick = solve(nums,i - 2,dp) + nums[i];
        int not_pick = solve(nums,i-1,dp);

        return dp[i] = Math.max(pick,not_pick);
    }
}
//tabulation
class Solution2 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length ; i++){
            int pick = nums[i];
            if(i > 1){
                pick += dp[i-2];
            }
            int not_pick = 0 + dp[i-1];
            dp[i] = Math.max(pick,not_pick);
        }
        return dp[nums.length - 1];
    }
}
}
