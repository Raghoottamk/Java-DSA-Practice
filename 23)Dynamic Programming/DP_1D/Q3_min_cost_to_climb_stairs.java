import java.util.Arrays;

public class Q3_min_cost_to_climb_stairs {

    //recursion solution
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int ans = Math.min(solve(cost.length - 1,cost),solve(cost.length - 2 , cost));
            return ans;
        }
        private int solve(int n,int[] cost){
            // if(n == 0) return cost[0];
            // if(n == 1) return cost[1];
            if(n <= 1) return cost[n];
            if(n < 0) return 0;
    
            int oneStep = solve(n - 1,cost);
            int twoStep = solve(n - 2,cost);
            return cost[n] + Math.min(oneStep , twoStep);
        }
    }
    
    //memoization
    class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = Math.min(solve(n - 1,cost,dp),solve(n - 2 , cost,dp));
        return ans;
    }
    private int solve(int n,int[] cost,int[] dp){
        // if(n == 0) return cost[0];
        // if(n == 1) return cost[1];
        if(n <= 1) return cost[n];
        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];

        int oneStep = solve(n - 1,cost,dp);
        int twoStep = solve(n - 2,cost,dp);
        dp[n] = cost[n] + Math.min(oneStep , twoStep);
        return dp[n];
    }
}
}