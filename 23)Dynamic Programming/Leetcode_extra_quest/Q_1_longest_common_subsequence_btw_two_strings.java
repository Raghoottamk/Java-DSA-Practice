package Leetcode_extra_quest;

import java.util.Arrays;

/*
Question--
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 */
public class Q_1_longest_common_subsequence_btw_two_strings {
    //normal recursion
    class Solution {

        public int longestCommonSubsequence(String text1, String text2) {
            
            return solve(text1,text2,0,0);
        }
        private int solve(String t1,String t2,int idx1,int idx2){
            //base
            if(idx1 == t1.length() || idx2 == t2.length() ){
                return 0;
            }
            int pick = 0;
            if(t1.charAt(idx1) == t2.charAt(idx2)){
                pick = 1 + solve(t1,t2,idx1 + 1,idx2 + 1);
                return pick;
            }
            else{
                return Math.max(solve(t1,t2,idx1+1,idx2),solve(t1,t2,idx1,idx2 + 1));
            }   
        }
    }
    //memoization
    class Solution2 {

        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length();
            int n2 = text2.length();
            int[][] dp = new int[n1][n2];
            for(int[] arr : dp) Arrays.fill(arr,-1);
            return solve(text1,text2,0,0,dp);
        }
        private int solve(String t1,String t2,int idx1,int idx2,int[][] dp){
            //base
            if(idx1 == t1.length() || idx2 == t2.length() ){
                return 0;
            }
            if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
            int pick = 0;
            if(t1.charAt(idx1) == t2.charAt(idx2)){
                pick = 1 + solve(t1,t2,idx1 + 1,idx2 + 1,dp);
                return pick;
            }
            int not_pick = Math.max(solve(t1,t2,idx1+1,idx2,dp),solve(t1,t2,idx1,idx2 + 1,dp));
            return dp[idx1][idx2] = Math.max(pick,not_pick);
        
        }
    }

    //tabulation
    class Solution3 {
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length(),n2 = text2.length();
            int[][] dp = new int[n1 + 1][n2 +1];
            for(int i = 1; i <= n1; i++){
                for(int j = 1; j <= n2 ; j++){
                    if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j - 1]);
                    }
                }
            }
            return dp[n1][n2];
        }
    }
}
