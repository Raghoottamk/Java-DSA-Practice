import java.util.Arrays;
//https://leetcode.com/problems/cherry-pickup-ii/?envType=daily-question&envId=2024-02-11
public class Q3_cherry_pickup2 {
    //recursion

class Solution2 {
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [][][]dp = new int [row][col][col];
        for(var arr2D : dp){
            for(var arr : arr2D){
                Arrays.fill(arr,-1);
            }
        }
        return solve(0,col - 1, 0 ,grid,dp);
    }
    //robot A is at Acol
    //robot B is at bcol
    private int solve(int Acol,int Bcol,int currRow,int[][]grid,int[][][] dp){
        if(currRow == grid.length) return 0;
        if(Acol < 0 || Bcol < 0 || Acol >= grid[0].length || Bcol >= grid[0].length) return 0;
        if(dp[currRow][Acol][Bcol] != -1) return dp[currRow][Acol][Bcol];

        int max = 0;//to select the max value in the search operation(DFS)
        for(int i = Acol - 1; i <= Acol + 1 ; i++){
            for(int j = Bcol - 1; j <= Bcol + 1; j ++){
                //avoid cross over because it olny increses complexity so 
                if(i <= j){
                    max = Math.max(max,solve(i,j,currRow + 1,grid,dp));
                }
            }
        }
        //add the maximum selected element to the result
        int ans = 0;
        //Add the present value to result
        if(Acol == Bcol){
            ans += grid[currRow][Acol];//or ans += grid[currRow][Bcol]
        }
        else{
            ans += (grid[currRow][Acol] + grid[currRow][Bcol]);
        }
        //select best combination of both A and B robots
        //as robots can move from [i+1][j-1 or j or j+1]
        ans += max;
        
        return dp[currRow][Acol][Bcol] = ans;
    }
}
}