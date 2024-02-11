

import java.util.Arrays;
/*
--Question--
There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.
If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. 
Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.
 */
public class Q4_frog_jumps {
    //memoization
    public class Solution1 {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,heights,dp);
    }
    private static int solve(int ind,int[] heights,int[] dp){
        if(ind == 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        int one = solve(ind - 1,heights,dp) + Math.abs(heights[ind] - heights[ind - 1]);
        int two = Integer.MAX_VALUE;
        if(ind > 1){
            two = solve(ind - 2, heights,dp) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return dp[ind] = Math.min(one,two);
    }
}

    //tabulation
    public class Solution2 {
        public static int frogJump(int n, int heights[]) {
            int[] dp = new int[n];
            dp[0] = 0;
            for(int i = 1; i < n; i++){
                int one = dp[i -1] + Math.abs(heights[i] - heights[i-1]);
                int two = Integer.MAX_VALUE;
                if(i > 1){
                    two = dp[i - 2] + Math.abs(heights[i] - heights[i-2]);
                }
                dp[i] = Math.min(one,two);
            }
            return dp[n - 1];
        }
    
    }

    //space optimization
    public class Solution3 {
        public static int frogJump(int n, int heights[]) {
            int prev = 0;
            int prev2 = 0;
            for(int i = 1; i < n; i++){
                int one = prev + Math.abs(heights[i] - heights[i-1]);
                int two = Integer.MAX_VALUE;
                if(i > 1){
                    two = prev2 + Math.abs(heights[i] - heights[i-2]);
                }
                int curri = Math.min(one,two);
                prev2 = prev;
                prev = curri;
            }
            return prev;
        }
    
    }
}
