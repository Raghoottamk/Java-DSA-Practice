package Leetcode_extra_quest;

import java.util.Arrays;
/*
Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class Q4_perfect_squares {
//normal recursion
class Solution {
    public int numSquares(int n) {
        return solve(n);
    }

    private int solve(int n) {
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); ++i){
            int cnt = 1 + solve(n- i*i);
            min = Math.min(min,cnt);
        }
        return min;
    }
}
//memoization
class Solution2 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    private int solve(int n, int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int ans = Integer.MAX_VALUE;

        for(int i = 1; i*i <= n; i++){
            int count = 1 + solve(n - i*i,dp);
            ans = Math.min(ans,count);
        }
        dp[n] = ans;
        return dp[n];
    }
}
}
