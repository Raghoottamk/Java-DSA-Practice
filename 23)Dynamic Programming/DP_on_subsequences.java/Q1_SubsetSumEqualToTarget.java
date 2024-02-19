public class Q1_SubsetSumEqualToTarget {
    //https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?leftPanelTabValue=PROBLEM
    //memoization
    class Solution {
        public static boolean subsetSumToK(int n, int k, int arr[]){
            // Write your code here.
            int[][] dp = new int[n][k+1];
            for(int[] ar : dp){
                Arrays.fill(ar,-1);
            }
            return solve(n-1,k,arr,dp);
        }
        private static boolean solve(int idx , int k , int[] arr,int[][] dp){
            if(k == 0) return true;
            if(idx == 0){
                return arr[0] == k;
            }
            if(dp[idx][k] != -1) return dp[idx][k] == 0 ? false : true;
            //pick
            boolean b1= false;
            if(arr[idx] <= k)
                b1 = solve(idx - 1,k-arr[idx],arr,dp);
            //not pick
            boolean b2 = solve(idx - 1,k,arr,dp);
            dp[idx][k] = b1 || b2 ? 1 : 0 ;
            return b1 || b2;
        }
    }
    //tabulation
    class Solution2 {
        public static boolean subsetSumToK(int n, int k, int arr[]){
            // Write your code here.
            boolean[][] dp = new boolean[n][k+1];
            for(int i = 0; i < n; i++){
                dp[i][0] = true;
            }
            if(arr[0] <= k) dp[0][arr[0]] = true;
    
            for (int ind = 1; ind < n; ind++) {
                for (int target = 1; target <= k; target++) {
                    // Calculate if the current target can be achieved without taking the current element
                    boolean notTaken = dp[ind - 1][target];
                    
                    // Calculate if the current target can be achieved by taking the current element
                    boolean taken = false;
                    if (arr[ind] <= target) {
                        taken = dp[ind - 1][target - arr[ind]];
                    }
                    
                    // Store the result in the DP table
                    dp[ind][target] = notTaken || taken;
                }
            }
    
            // The final result is stored in the bottom-right cell of the DP table
            return dp[n - 1][k];
        }
    }
}