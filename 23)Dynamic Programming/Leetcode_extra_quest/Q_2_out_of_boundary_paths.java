package Leetcode_extra_quest;

import java.util.Arrays;
/*
Question--
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

Example 1:
Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6

Example 2:
Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
 */

public class Q_2_out_of_boundary_paths {

    class Solution {
        int modulo = 1000000007;
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            //recursion
            //return solve(m ,n , maxMove, startRow, startColumn);

            //dp memoization
            //3d array cause 3 parameters keeps on changing so maxmove,start row ,start col
            int dp[][][] = new int [m][n][maxMove+1];
            for(var arr2d : dp){
                for(var arr : arr2d ){
                    Arrays.fill(arr,-1);
                }
            }
            
            return solve(m ,n , maxMove, startRow, startColumn,dp);
        }
        private int solve(int m, int n, int mm, int sr, int sc,int[][][] dp){
            //recursion
            // if(sc < 0 || sc >= n || sr < 0 || sr >= m) return 1;

            // int up = 0,down = 0,left = 0, right = 0;

            // if(mm > 0) up = solve(m , n , mm -1 , sr - 1,sc );
            // if(mm > 0) down = solve(m ,n , mm -1 , sr + 1 ,sc );
            // if(mm > 0) left = solve(m , n , mm -1, sr, sc - 1);
            // if(mm > 0) right = solve(m , n , mm -1 , sr , sc + 1);

            // return (up + down + left + right) % modulo;
            //memo
            if(sc < 0 || sc >= n || sr < 0 || sr >= m) return 1;
            if(mm == 0) return 0;
            if(dp[sr][sc][mm] != -1) return dp[sr][sc][mm];

            int up = solve(m , n , mm -1 , sr - 1,sc,dp) ;
            int down = solve(m ,n , mm -1 , sr + 1 ,sc,dp ) ;
            int left = solve(m , n , mm -1, sr, sc - 1,dp) ;
            int right = solve(m , n , mm -1 , sr , sc + 1,dp) ;

            return dp[sr][sc][mm] = ((up + down) % modulo + (left + right) % modulo) % modulo;
        }
    }
}