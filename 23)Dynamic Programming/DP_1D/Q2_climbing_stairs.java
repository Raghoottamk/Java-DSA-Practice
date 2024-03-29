import java.util.Arrays;
/*
--Question--
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/
public class Q2_climbing_stairs {
    //recursion
    class Solution1 {
        public int climbStairs(int n) {
            if(n == 0) return 1;
            //edge case when n == 1 and we call for n-2
            if(n < 0) return 0;
    
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
    //memoiztion
    class Solution2 {
        public int climbStairs(int n) {
            int[] dp  = new int[n+1];
            Arrays.fill(dp,-1);
            return solve(n,dp);
        }
        private int solve(int n ,int[] dp){
            if(n == 0) return 1;
            if(n < 0) return 0;

            if(dp[n] != -1) return dp[n];

            dp[n] = solve(n - 1,dp) + solve(n-2,dp);
            return dp[n];
        }
    }
    //tabulation
    class Solution3 {
        public int climbStairs(int n) {
            //tabulation
            int[] dp = new int[n+1];
            dp[0] = 1;//one way when no stairs is to climb
            dp[1] = 1;//one way when only oe stair is to be climbed
            for(int i = 2; i <= n ; i++){
                dp[i] = dp[i-1] + dp[i - 2];
            }
            return dp[n];
        }
    }
    //space optimization
    class Solution4 {
        public int climbStairs(int n) {
            //tabulation
            int prev2 = 1;//one way when no stairs is to climb
            int prev1 = 1;//one way when only oe stair is to be climbed
            for(int i = 2; i <= n ; i++){
                int curr = prev2 + prev1;
                prev2 = prev1;
                prev1 = curr;
            }
            return prev1;
        }
    }
}
