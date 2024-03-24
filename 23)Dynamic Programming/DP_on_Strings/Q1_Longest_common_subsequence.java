public class Q1_Longest_common_subsequence {
//https://leetcode.com/problems/longest-common-subsequence/
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length() , n2 = text2.length();
            int[][] dp = new int[n1+1][n2+1];
            //shifting fo index by one i and j vary from -1 -> n1-1 || n2-1
            //as base case lies in index -1
            //so the cases changes slightly like
            //solve(n1-1,n2-1) would give ans but due to shifting dp[n1][n2] will have answer instead of dp[1-1][n2-1]
            //so now base case would be when i == 0 || j == 0 instead of i < 0 || j < 0
            //thats already zero as array created in java default value is 0
            for(int i = 1; i <= n1 ; i++){
                for(int j = 1; j <= n2 ; j++){
                    if(text1.charAt(i-1) == text2.charAt(j-1)){//hshifting of indices
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
            //recursive solution down
            //return solve(n1-1,n2-1,text1,text2);
        }
        private int solve(int ind1 ,int ind2,String s1, String s2){
            //base
            if(ind1 < 0 || ind2 < 0){
                return 0;
            }
            // 1st - recursive call when the characters match
            // match
            if (s1.charAt(ind1) == s2.charAt(ind2)) {
                return 1 + solve(ind1 - 1, ind2 - 1, s1, s2);
            }
            // 2nd - not match
            // return max of not pick among both the possibilities
            int m1 = solve(ind1 - 1, ind2, s1, s2);
            int m2 = solve(ind1, ind2 - 1, s1, s2);
            return Math.max(m1, m2);
        }
    }
}