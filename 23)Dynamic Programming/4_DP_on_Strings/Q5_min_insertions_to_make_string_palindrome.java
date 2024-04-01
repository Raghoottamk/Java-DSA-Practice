public class Q5_min_insertions_to_make_string_palindrome {
    //https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

    //we know that if maximum insertions = length of given string itself 
    //as we can append reverse of string to the given string to make it palindrome
    class Solution {
        public int minInsertions(String s) {
            int n = s.length();
            //formula
            //min insertions = n - lengthOf(LPS), where LPS -> longest Palindromic Subsequence
            int LPS = longestPalindromeSubseq(s);
            return n - LPS;
        }
        private int longestPalindromeSubseq(String s) {
            //a string reverse of s and longest common sbsequece b/w them is would be the longestPalindromic subsequece
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            String s2 = sb.toString();
            return longestCommonSubsequence(s,s2);
        }
        private int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length() , n2 = text2.length();
            int[][] dp = new int[n1+1][n2+1];
            for(int i = 1; i <= n1 ; i++){
                for(int j = 1; j <= n2 ; j++){
                    if(text1.charAt(i-1) == text2.charAt(j-1)){//shifting of indices
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        int m1 = dp[i-1][j];
                        int m2 = dp[i][j-1];
                        dp[i][j] = Math.max(m1,m2);
                    }
                }
            }
            return dp[n1][n2];
        }
    }
}
