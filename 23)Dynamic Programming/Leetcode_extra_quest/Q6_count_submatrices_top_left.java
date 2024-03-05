/*
count submatrices with top left element and sum less than k

https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/
 */
public class Q6_count_submatrices_top_left {
    class Solution {
        /*
        1st row: dp[0][i] = dp[0][i-1] + grid[0][i]
        1st coloum: dp[i][0] = dp[i-1][0] + grid[i][0]
        Any Rectangle Area: dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + grid[i][j]
        */
        public int countSubmatrices(int[][] grid, int k) {
            int count = 0;
            int m = grid.length; int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            if(dp[0][0] <= k) count = 1;
    
            //first row
            for(int i = 1; i < n ; i++){
                dp[0][i] = grid[0][i] + dp[0][i-1];
                if(dp[0][i] <= k){
                    count++;
                }
            }
            //first col
            for(int i = 1 ; i < m ; i++){
                dp[i][0] = grid[i][0] + dp[i-1][0];
                if(dp[i][0] <= k){
                    count++;
                }
            }
            //rectangle
            for(int i = 1; i < m ; i++){
                for(int j = 1; j < n; j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + grid[i][j];
                    if(dp[i][j] <= k){
                        count++;
                    }
                }
            }
            return count;
        }
    }
    //greedy approach
    class Solution2 {
        public int countSubmatrices(int[][] grid, int k) {
          int m = grid.length;
            int n = grid[0].length;
            int[][] ps = new int[m + 1][n + 1];
            int res = 0;
    
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + grid[i - 1][j - 1];
                    res += ps[i][j] <= k ? 1 : 0;
                }
            }
    
            return res;
        }
    }
    //greedy 2
    //note: the way of iteration performed in prefixsum will be opposite in iteration to count the number of possibilities 
    class Solution3 {
        public int countSubmatrices(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] sum = new int[m][n];
            
            for(int j=0; j<n; j++) {
                for(int i=0; i<m; i++) {
                    if(i == 0) {
                        sum[i][j] = grid[i][j];
                    } else {
                        sum[i][j] = grid[i][j] + sum[i-1][j];
                    }
                }
            }
            
            int count = 0;
            for(int i=0; i<m; i++) {
                int j=0;
                int currSum = sum[i][j];
                while(currSum <= k && j < n) {
                    count++;
                    j++;
                    if(j < n)
                        currSum += sum[i][j];
                }
            }
            
            return count;
        }
    }
}