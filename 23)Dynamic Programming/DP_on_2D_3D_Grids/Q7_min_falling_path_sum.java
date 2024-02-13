import java.util.Arrays;
//https://leetcode.com/problems/minimum-falling-path-sum/description/
public class Q7_min_falling_path_sum {
    //memoization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(var arr : dp){
            Arrays.fill(arr,-1);
        }
        // as there are m no. elements in every row we need to solve for each possibilty of start
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            ans = Math.min(ans,solve(n-1,j,matrix,dp));
        }
        return ans;
    }
    private int solve(int i, int j ,int[][] mat,int[][] dp){
        
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) return (int)1e9;
        if(i == 0 ) return mat[0][j];
        if(dp[i][j] != -1) return dp[i][j];

        int up = mat[i][j] + solve(i-1,j,mat,dp);
        int diagL = mat[i][j] + solve(i-1,j-1,mat,dp);
        int diagR = mat[i][j] + solve(i-1,j+1,mat,dp);

        return dp[i][j] = Math.min(up,Math.min(diagL,diagR));
    }
}
//tabulation
class Solution2 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        //base cases for tabulation
        for(int j = 0; j < m ; j++){
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(10, 9);
                }

                // Store the maximum of the three paths in dp
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Find the min value in the last row of dp
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }

        return min;
        
    }
}
}
