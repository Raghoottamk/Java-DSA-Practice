import java.util.ArrayList;
import java.util.Arrays;
/*
https://leetcode.com/problems/house-robber-ii/
 */
public class Q7_house_robber2 {
    //memoization
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int a = solve(nums,0,nums.length - 2, dp);
        Arrays.fill(dp,-1);
        int b = solve(nums,1,nums.length - 1, dp);
        return Math.max(a,b);
    }
    private int solve(int[] nums,int start,int i,int[] dp){
        if(start > i) return 0;

        if(dp[i] != -1) return dp[i];
        
        int pick = nums[i] + solve(nums,start,i - 2,dp);
        int not_pick = 0 + solve(nums,start,i-1,dp);

        return dp[i] = Math.max(pick,not_pick);
    }
}
//Space optimization
class solution2{
    private long solve(ArrayList<Integer> arr){
        int n = arr.size();
        long prev = arr.get(0);
        long prev2 =0;
        
        for(int i=1; i<n; i++){
            long pick = arr.get(i);
            if(i>1)
                pick += prev2;
            long nonPick = 0 + prev;
            
            long cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev= cur_i;
            
        }
        return prev;
}

    public long robStreet(int n, ArrayList<Integer> arr){
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();

        if(n==1)
        return arr.get(0);
        
        for(int i=0; i<n; i++){
            
            if(i!=0) arr1.add(arr.get(i));
            if(i!=n-1) arr2.add(arr.get(i));
        }
        
        long ans1 = solve(arr1);
        long ans2 = solve(arr2);
        
        return Math.max(ans1,ans2);
    }
}
}
