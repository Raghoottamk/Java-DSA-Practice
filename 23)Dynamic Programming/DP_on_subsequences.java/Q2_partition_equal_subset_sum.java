import java.util.Arrays;

public class Q2_partition_equal_subset_sum {
//https://leetcode.com/problems/partition-equal-subset-sum/submissions/1179521902/
//memoization
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length ; i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 == 1) return false; //odd total sum cannot be divided into two halves
        int[][] dp = new int[nums.length][totalSum/2 + 1];
        for(var arr : dp){
            Arrays.fill(arr,-1);
        }
        return solve(nums,nums.length -1,totalSum/2,dp);
    }
    private boolean solve(int[] nums,int idx,int target,int[][] dp){
        if(target == 0) return true;
        if(idx == 0) return nums[idx] == target;
        if(dp[idx][target] != -1) return dp[idx][target] == 0 ? false : true;
        
        //pick
        boolean pick = false;
        if(nums[idx] <= target){
            pick = solve(nums,idx-1,target-nums[idx],dp);
        }
        //not pick
        boolean not_pick = solve(nums,idx-1,target,dp);
        dp[idx][target] = pick || not_pick ? 1 : 0;
        return pick || not_pick;
    }
}
//tabulation
class Solution2 {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length ; i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 == 1) return false; //odd total sum cannot be divided into two halves
        int target = totalSum/2;
        boolean[][] dp = new boolean[nums.length][target+1];
        //base cases
        //base case 1 : if(target == 0) return true;
        for(int i = 0; i < nums.length ; i++){
            dp[i][0] = true;
        }

        //base case 2 : if(idx == 0) return nums[idx] == target;
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        for(int i = 1; i < nums.length; i++){
            for(int k = 1; k <= target ; k++){
                boolean not_pick = dp[i-1][k];

                boolean pick = false;
                if(nums[i] <= k){
                    pick = dp[i-1][k - nums[i]];
                }
                
                dp[i][k] = pick || not_pick;
            }
        }

        return dp[nums.length-1][target];
    }
}
}
