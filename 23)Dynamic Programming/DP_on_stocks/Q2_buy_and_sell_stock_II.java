import java.util.*;
public class Q2_buy_and_sell_stock_II {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
class Memoization {
    //memo
    public int maxProfit(int[] prices) {
        int buy = 1;
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,buy,prices,dp);
    }
    private int solve(int ind, int buy,int[] prices,int[][] dp){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int maxBuy = 0;
        int maxSell = 0;
        if(buy == 1){
            //pick 
            int p = -prices[ind] + solve(ind + 1,0,prices,dp);
            //not pick
            int np = solve(ind + 1,1,prices,dp);
            maxBuy = Math.max(p,np);
        }
        else{
            //sell
            int p = prices[ind] + solve(ind+1,1,prices,dp);
            int np = solve(ind+1,0,prices,dp);
            maxSell = Math.max(p,np);
        }
        return dp[ind][buy] = Math.max(maxBuy,maxSell);
    }
}
class Tabulation {
    public int maxProfit(int[] prices) {
        //int buy = 1;
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        
        for (int ind = n - 1; ind >= 0; ind--){
            for (int buy = 0; buy <= 1; buy++){
                int maxBuy = 0, maxSell = 0;
                if (buy == 1){
                    maxBuy = Math.max(0 + dp[ind + 1][1], -prices[ind] + dp[ind + 1][0]);
                }
                else{
                    maxSell = Math.max(0 + dp[ind + 1][0], prices[ind] + dp[ind + 1][1]);
                }
                

                dp[ind][buy] = Math.max(maxBuy,maxSell);
            }
        }
        //return solve(0,buy,prices,dp);
        return dp[0][1];
    }
}
class SpaceOptimization {
    public int maxProfit(int[] prices) {
        //int buy = 1;
        int n = prices.length;
        int[] ahead = new int[2];
        ahead[0] = ahead[1] = 0;
        int[] curr = new int[2];
        
        for (int ind = n - 1; ind >= 0; ind--){
            for (int buy = 0; buy <= 1; buy++){
                int maxBuy = 0, maxSell = 0;
                if (buy == 1){
                    maxBuy = Math.max(0 + ahead[1], -prices[ind] + ahead[0]);
                }
                else{
                    maxSell = Math.max(0 + ahead[0], prices[ind] + ahead[1]);
                }
                curr[buy] = Math.max(maxBuy,maxSell);
            }
            ahead = curr;
        }
        //return solve(0,buy,prices,dp);
        return ahead[1];
    }
}
}
