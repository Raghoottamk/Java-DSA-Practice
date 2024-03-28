public class Q8_Distinct_subsequences {
//https://leetcode.com/problems/distinct-subsequences/description/
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        //for memoization
        //int[][] dp = new int[m][n];
        // for(int[] arr : dp){
        //     Arrays.fill(arr,-1);
        // }
        //return solve(m-1,n-1,s,t,dp);

        //tabulation
        //shifting of indices by 1 so as to achieve i=-1 or j = -1 base cases as i = = and j = 0
        int[][] dp = new int[m+1][n+1];
        for(int i = 0 ; i <= m ; i++){
            dp[i][0] = 1;
        }
        //j will start from 1 not from 0
        //coz, we want to avoid dp[0][0] = 0, as we want dp[0][0] = 1 done i previous loop
        //though this loop j->1 to n not required in java as it as default value as 0
        for(int j = 1; j <= n; j++){
            dp[0][j] = 0;
        }
        
        //work
        for(int i = 1; i <= m ; i++){
            for(int j = 1; j <= n ; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    int pick1 = dp[i-1][j-1];
                    int pick2 = dp[i-1][j];
                    dp[i][j] = pick1 + pick2;
                }
                else{
                    int notPick = dp[i-1][j];
                    dp[i][j] = notPick;
                }
            }
        }
        return dp[m][n];
    }
    private int solve(int i,int j,String s,String t,int[][] dp){
        //base cases
        if(j < 0) return 1;//all charecters from t are picked
        if(i < 0) return 0;//before picking all the charaters of t , we reached end of string s
        
        if(dp[i][j] != -1) return dp[i][j];
        //work
        if(s.charAt(i) == t.charAt(j)){
            //pick it from s
            //ex- s = "babgbag", t = "bag"
            //g from s is taken and compared with g of t
            //now i need to search for 'a' of t in string s
            int pick1 = solve(i-1,j-1,s,t,dp);
            //even if character matches dont pick from s
            //g from "babgbag" at ind 6 is not taken instead we are want to pick g at ind 3 which would be done by recursive call
            //presently I just want to skip the present g
            int pick2 = solve(i-1,j,s,t,dp);
            return dp[i][j] = pick1 + pick2;
        }
        else{
            // caracters does not match look ahead in string s
            return dp[i][j] = solve(i-1,j,s,t,dp);
        }
    }
}
}