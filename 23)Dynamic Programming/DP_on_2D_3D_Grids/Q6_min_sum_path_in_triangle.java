import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/triangle/description/
public class Q6_min_sum_path_in_triangle {
    //memoization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //unlike other problems we cant directly start from the last index and reach the first index 
        //coz we have reaching any element in last row would be our base case

        int max_i = triangle.size() - 1;
        int max_j = triangle.get(max_i).size() - 1;
        int[][] dp = new int[max_i +1][max_j + 1];
        for(var arr : dp){
            Arrays.fill(arr,(int)1e9);
        }
        return solve(0,0,max_i,max_j,triangle,dp);
    }
    private int solve(int i , int j ,int max_i,int max_j,List<List<Integer>> tri,int[][] dp){
        if(i == max_i){
            return tri.get(i).get(j) ;
        }
        if(dp[i][j] != (int)1e9) return dp[i][j];
        //(i+1,j) and (i+1,j+1) are the only two moves so there is possibility of index out ofbounds condition
        //down
        int down = tri.get(i).get(j) + solve(i+1,j,max_i,max_j,tri,dp);
        int diag = tri.get(i).get(j) + solve(i+1,j+1,max_i,max_j,tri,dp);

        return dp[i][j] = Math.min(down,diag);
    }
}
    //tabulation
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        //unlike other problems we cant directly start from the last index and reach the first index 
        //coz we have reaching any element in last row would be our base case

        int n = triangle.size();
        //by observation we can say that length of last row = total no. of rows
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        //bottmom up tabulation
        for(int i = n - 2 ; i >= 0 ; --i){
            for(int j = i ; j >= 0 ; --j){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(down,diag);
            }
        }

        return dp[0][0];
    }
}
}
