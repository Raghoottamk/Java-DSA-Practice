import java.util.*;

public class Q2_Print_LIS {
    //https://www.naukri.com/code360/problems/printing-longest-increasing-subsequence_8360670?leftPanelTabValue=PROBLEM
    public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
        // Write Your Code Here
        int n = arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        Arrays.fill(hash,1);
        
        for(int i=0; i<=n-1; i++){
            
            hash[i] = i; // initializing with current index
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                
                if(arr[prev_index]<arr[i] && 1 + dp[prev_index] > dp[i]){
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }
        
        int ans = -1;
        int lastIndex =-1;
        
        for(int i=0; i<=n-1; i++){
            if(dp[i]> ans){
                ans = dp[i];
                lastIndex = i;
            }
        }
        
        List<Integer> temp=new ArrayList<>();
        temp.add(arr[lastIndex]);
        
        while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);    
        }
        return temp;
    }
}
