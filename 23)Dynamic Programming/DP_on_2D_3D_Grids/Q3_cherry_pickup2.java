import java.util.Arrays;
//https://leetcode.com/problems/cherry-pickup-ii/?envType=daily-question&envId=2024-02-11
public class Q3_cherry_pickup2 {
/*recursion 
    TC=O(9)^(rows*cols*cols)
    sc = O(rows)
*/

/*memoization
    TC = 9*(rows*cols*cols) 
    SC = O(rows**cols*cols)dp array + O(rows)stack space
*/
class Solution1 {
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

/*Tabulation
    TC = 9(rows*cols*cols)
    base =
 */
class Solution2 {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];
        int ans = 0;

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                Arrays.fill(dp[i][j], -1);

        dp[0][0][n-1] = grid[0][0] + grid[0][n-1];
        //other indices for dp[0][0][x] not required coz in first row we can pick only the first 0th and n-1 col cherries

        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) { // robotA
                for(int k=j+1;k<n;k++) { // robotB
                    int max = -1;
                    for(int x=-1;x<=1;x++) { // we will have total 9 combinations
                        for(int y=-1;y<=1;y++) {
                            if(j+x >= 0 && j+x < n && k+y >= 0 && k+y < n){
                                if(j+x < k+x){//avoid cross over as it does n't make any sense
                                    max = Math.max(max,dp[i-1][j+x][k+y]);
                                }
                            }
                        }
                    }
                    if(max != -1)
                        dp[i][j][k] = max + grid[i][j] + grid[i][k];
                    if(ans < dp[i][j][k]) ans = dp[i][j][k];
                }
            }
        }

        return ans;
    }
}
}