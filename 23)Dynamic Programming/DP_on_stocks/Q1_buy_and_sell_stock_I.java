public class Q1_buy_and_sell_stock_I {

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buyprice = Integer.MAX_VALUE;
        //currprice would be the price at which stock is sold
        int maxprofit = 0;
        for(int i=0;i<n;i++){
            if(buyprice < prices[i]){
                int profit = prices[i] - buyprice;
                maxprofit = Math.max(maxprofit,profit);
            }
            else{
                buyprice = prices[i]; 
            }
        }
        return maxprofit;
    }
}
}