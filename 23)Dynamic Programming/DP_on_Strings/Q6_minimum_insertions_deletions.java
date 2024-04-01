public class Q6_minimum_insertions_deletions {
//https://leetcode.com/problems/delete-operation-for-two-strings/
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];//shifting indices by one place so that achieve recursive base case when i < 0 || j < 0

        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i <= m; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    int m1 = dp[i][j-1];
                    int m2 = dp[i-1][j];
                    dp[i][j] = Math.max(m1,m2);
                }
            }
        }
        //longest common subsequence
        int lcsLength = dp[n][m];
        int ans = m - lcsLength + n - lcsLength;
        return ans;
    }
}
}