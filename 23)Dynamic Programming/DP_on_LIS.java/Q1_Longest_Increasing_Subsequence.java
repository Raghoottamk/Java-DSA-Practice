import java.util.*;
public class Q1_Longest_Increasing_Subsequence {
    //https://leetcode.com/problems/longest-increasing-subsequence/description/
    class Solution1 {
        //simple recusive solution
        //drawback of this solution is it cannot be memoized as last int varies in very large range
        //so dynamic programming cant be done to optimize this solution
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            //find max
            return solve(n-1,(int)1e9,nums);
        }
        private int solve(int ind , int lastInt , int[] nums){
            if(ind == 0){
                if(lastInt > nums[0]) return 1;
                return 0;
            }
            //pick
            int p = 0;//and reduce the index
            if(nums[ind] < lastInt){
                p = 1 + solve(ind-1 , nums[ind] , nums);
            }
            int np = solve(ind-1 , lastInt , nums);
    
            return Math.max(p,np);
        }
    }
    class Solution2 {
        //this solution can be optimized to DP further
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            
            return solve(0,-1,nums);
        }
        private int solve(int ind , int prevInd , int[] nums){
            if(ind == nums.length) return 0;
            int p = 0;
            if(prevInd == -1 || nums[ind] > nums[prevInd]){
                p = 1 + solve(ind+1 , ind , nums);
            }
            int np = solve(ind+1 , prevInd , nums);
            return Math.max(p , np);
        }
    }
    
    class Solution3 {
        //memoization
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][n+1];//indexshifting on prevInd by one to even solve on -1 index
            for(int[] arr : dp){
                Arrays.fill(arr,-1);
            }
            return solve(0,-1,nums,dp);
        }
        private int solve(int ind , int prevInd , int[] nums,int[][] dp){
            if(ind == nums.length) return 0;
            if(dp[ind][prevInd+1] != -1) return dp[ind][prevInd+1];
            int p = 0;
            if(prevInd == -1 || nums[ind] > nums[prevInd]){
                p = 1 + solve(ind+1 , ind , nums,dp);
            }
            int np = solve(ind+1 , prevInd , nums,dp);
            return dp[ind][prevInd+1] = Math.max(p , np);
        }
    }
    class Solution4 {
        //tabulation
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n+1][n+1];//indexshifting on prevInd by one to even solve on -1 index
            for(int ind = n-1 ; ind >=0 ; ind--){
                for(int prevInd = ind-1 ; prevInd >= -1 ; prevInd--){
                    int p = 0;
                    if(prevInd == -1 || nums[ind] > nums[prevInd]){
                        p = 1 + dp[ind+1][ind+1];
                    }
                    int np = dp[ind+1][prevInd+1];
                    dp[ind][prevInd+1] = Math.max(p , np);
                }
            }
            //return solve(0,-1,nums,dp);
            return dp[0][0];
        }
    }
    class Solution5 {
        ////space optimization
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            //int[][] dp = new int[n+1][n+1];//indexshifting on prevInd by one to even solve on -1 index
            int[] curr = new int[n+1];
            int[] next = new int[n+1];
            for(int ind = n-1 ; ind >=0 ; ind--){
                for(int prevInd = ind-1 ; prevInd >= -1 ; prevInd--){
                    int p = 0;
                    if(prevInd == -1 || nums[ind] > nums[prevInd]){
                        p = 1 + next[ind+1];
                    }
                    int np = next[prevInd+1];
                    curr[prevInd+1] = Math.max(p , np);
                }
                next = curr.clone();
            }
            //return solve(0,-1,nums,dp);
            return curr[0];
        }
    }
    class Solution6 {
        //different way to solve this question
        //this approach can be used to print the LIS
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp,1);//every element in itself can be a subsequence
            //weird way of tabualtion
            /*
            calculate all the maximum subsequence possible till that particular index
            check for all the previous cases  which can be accomodated in present 
             */
            int maxi = 0;
            for(int i = 0; i < n ; i++){
                for(int j = 0 ; j < i ; j++){
                    if(nums[j] < nums[i]){
                        dp[i] = Math.max(dp[i],1 + dp[j]);
                    }
                }
                maxi = Math.max(maxi , dp[i]);
            }
    
            return maxi;
        }
    }
}