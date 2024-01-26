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
    static void tabulation(int n,int[] dp){
        Arrays.fill(dp,-1);
        dp[0]= 0;
        dp[1]= 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }
        System.out.println(dp[n]);
    }
/*
    --space optimization
If we closely look at the relation,
dp[i] =  dp[i-1] + dp[i-2]

we see that for any i, we do need only the last two values in the array. So is there a need to maintain a whole array for it? 
The answer is ‘No’. Let us call dp[i-1] as prev and dp[i-2] as prev2. Now understand the following illustration.

    step-1- Each iteration’s cur_i and prev becomes the next iteration’s prev and prev2 respectively.
    step-2- herefore after calculating cur_i, if we update prev and prev2 according to the next step, we will always get the answer. 
    step-3- After the iterative loop has ended we can simply return prev as our answer.
    
 */
    static void space_opti(int n){
        int prev2 = 0;
        int prev = 1;
        
        for(int i=2; i<=n; i++){
            int cur_i = prev2+ prev;
            prev2 = prev;
            prev= cur_i;
        }
        System.out.println(prev);
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
        tabulation(n, dp2);

        //space optimization
        space_opti(n);
    }
}