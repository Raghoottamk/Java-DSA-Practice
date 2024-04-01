public class Q4_Longest_palindromic_substring {

    //Brute force solve using normal recursion by genereating all subsequces and comparing if its palindrome or not
    class Solution {
        int res = 0;
        public int longestPalindromeSubseq(String s) {
            if(isPalindrome(s)) return s.length();
            solve(0,"",s);
            return res;
        }
    
        private void solve(int ind, String ans, String s) {
            if (ind == s.length()) {
                return;
            }
            int len = 0;
            if (isPalindrome(ans + s.charAt(ind))) {
                len = ans.length() + 1;
                res = Math.max(res,len);
            }
            solve(ind + 1, ans + s.charAt(ind), s);
            solve(ind + 1, ans, s);
        }
    
        private boolean isPalindrome(String s) {
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
    //better approach of using recursion without actually using isPalindrom()
    class Solution2 {
        public int longestPalindromeSubseq(String s) {
            return solve(0, s.length() - 1, s);
        }
    
        private int solve(int start, int end, String s) {
            if (start > end) {
                return 0;
            } else if (start == end) {
                return 1;
            }
            
            if (s.charAt(start) == s.charAt(end)) {
                return 2 + solve(start + 1, end - 1, s);
            } else {
                int option1 = solve(start + 1, end, s);
                int option2 = solve(start, end - 1, s);
                return Math.max(option1, option2);
            }
        }
    }

    //best use DP
    //LongestcommonSubsequence b/w given sstring and reverse of the string would give the answer
    class Solution3 {
        public int longestPalindromeSubseq(String s) {
            //a string reverse of s and longest common sbsequece b/w them is would be the longestPalindromic subsequece
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            String s2 = sb.toString();
            return longestCommonSubsequence(s,s2);
        }
        private int longestCommonSubsequence(String text1, String text2) {
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
        }
    }
}