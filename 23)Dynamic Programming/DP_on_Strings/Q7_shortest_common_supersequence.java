public class Q7_shortest_common_supersequence {
//https://leetcode.com/problems/shortest-common-supersequence/
class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        //approach
        //the length of the ans = n + m - len(LCS)
        //construst another string ans
        //find the length of the longest common subsequence
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){//shifting of indices
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    int m1 = dp[i-1][j];
                    int m2 = dp[i][j-1];
                    dp[i][j] = Math.max(m1,m2);
                }
            }
        }
        //find the LCS string
        StringBuilder res = new StringBuilder();
        int i = n,j = m;
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                res.append(s1.charAt(i-1));//i-1 because of index shifting
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){//moving up in dp table
                //then pick the corresponding character 
                res.append(s1.charAt(i-1));//i-1 because of index shifting
                i--;
            }
            else{//moving down in dp table
                //if dp[i-1][j] == dp[i][j-1] , we can move anywhere i-1 or j-1 ,here we are moving j - 1
                //then pick the corresponding character 
                res.append(s2.charAt(j-1));//j-1 because of index shifting 
                j--;
            }
        }
        //we might end up anywhere in 0th index of i or j 
        //example -> i == 0 but still j = 1,2,3....... or j == 0 but i == 1,2,3........
        //we need to add all those charecters to the string
        while(i > 0){
            res.append(s1.charAt(i-1));
            i--;
        }
        while(j > 0){
            res.append(s2.charAt(j-1));
            j--;
        }
        //this string is reverse of the answer as we travel table in reverse order
        return String.valueOf(res.reverse());
    }
}
}
