import java.util.Arrays;
//https://leetcode.com/problems/wildcard-matching/description/
public class Q10_wild_card__matching {
class Solution {
    public boolean isMatch(String s2, String s1) {
        //let s1 = p
        //s2 = s
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n][m];
        for (int row[]: dp)
            Arrays.fill(row, -1);
        
        return solve(s1,s2,n-1,m-1,dp) == 0 ? false : true;
    }
    private int solve(String S1,String S2,int i,int j,int[][] dp){
        // Base Cases
        if (i < 0 && j < 0)
            return 1; // Both strings are empty, and the pattern matches
        if (i < 0 && j >= 0)
            return 0; // S1 is empty, but there are characters left in S2
        if (j < 0 && i >= 0){
            return isAllStars(S1, i) ? 1 : 0; // S2 is empty, check if remaining characters in S1 are all '*'
        }

        // If the result is already computed, return it.
        if (dp[i][j] != -1) return dp[i][j];

        // If the characters match or S1 has a '?', continue matching the rest of the strings
        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?'){
            return dp[i][j] = solve(S1, S2, i - 1, j - 1, dp);
        }

        else {
            if (S1.charAt(i) == '*') {
                // Two possibilities when encountering '*':
                // 1. '*' matches one or more characters in S2
                // 2. '*' matches zero characters in S2
                return dp[i][j] = (solve(S1, S2, i - 1, j, dp) == 1 || solve(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
            } 
            else{
                // Characters don't match, and S1[i] is not '*'.
                return 0;
            }
        }
    }

    private boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
        if (S1.charAt(j) != '*')
            return false;
        }
        return true;
    }
}
}
