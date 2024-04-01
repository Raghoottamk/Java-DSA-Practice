
//https://leetcode.com/problems/unique-paths-ii/description/

import java.util.Arrays;

public class Q4_grid_ways_obstacle {
//memoization
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        return solve(n - 1, m - 1, obstacleGrid, dp);
    }
    private int solve(int i, int j, int[][] maze, int[][] dp) {
        if (i >= 0 && j >= 0 && maze[i][j] == 1)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int up = solve(i - 1, j, maze, dp);
        int left = solve(i, j - 1, maze, dp);

        return dp[i][j] = up + left;
    }
}

//tabulation
class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i <= n - 1 ; ++i){
            for(int j = 0 ; j <= m -1 ; ++j){
                
                if(obstacleGrid[i][j] == 1) { 
                    dp[i][j] = 0; 
                    continue;
                }
                else if(i == 0 && j == 0) {
                    dp[i][j] = 1; 
                    continue;
                }
                int left = 0,up = 0;
                if(i > 0) up = dp[i-1][j];
                if(j > 0) left = dp[i][j-1];
                
                dp[i][j] = up + left;
            }
        }
        return dp[n-1][m-1];
    }
}
}
