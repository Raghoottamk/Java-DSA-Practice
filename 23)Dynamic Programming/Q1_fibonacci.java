import java.util.*;
public class Q1_fibonacci {

    //recursion
    static int recur(int n){
        if(n <= 1){
            return n;
        }
        return recur(n-1) + recur(n-2);
    }
    //memoization
    static int memo(int n,int [] dp){
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1) return dp[n];

        return dp[n] = memo(n-1, dp) + memo(n-2, dp);
    }
    /*
    --TABULATION--
Tabulation is a ‘bottom-up’ approach where we start from the base case and reach the final answer that we want.
Steps to convert Recursive Solution to Tabulation one.
    step-1- Declare a dp[] array of size n+1.
    step-2- First initialize the base condition values, i.e i=0 and i=1 of the dp array as 0 and 1 respectively.
    step-3- Set an iterative loop that traverses the array( from index 2 to n) and for every index set its value as dp[i-1] + dp[i-2]. 
     
Time Complexity: O(N)
    Reason: We are running a simple iterative loop

Space Complexity: O(N)
    Reason: We are using an external array of size ‘n+1’.
    */
    static int tabulation(int n,int[] dp){
        Arrays.fill(dp,-1);
        dp[0]= 0;
        dp[1]= 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        //normal recursion
        System.out.println(recur(n));
        //DP
        //1 memoization
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(memo(n, dp));
        /*
        for(int i = 0; i < dp.length ; i++){
            System.out.print(i + "," +dp[i] + " ");
        }
        */

        //tabulation
        int []dp2 = new int[n+1];
        System.out.println(tabulation(n, dp2));

        //space optimization
        
    }
}