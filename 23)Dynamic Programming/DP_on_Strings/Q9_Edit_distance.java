public class Q9_Edit_distance {

//https://leetcode.com/problems/edit-distance/description/

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(m == 0) return n;
        //maximum possible number is 
        //delete all elements of word2 and add all elements of word1 = n + m

        //memoization 
        // int[][] dp = new int[n][m];
        // for(int[] arr : dp){
        //     Arrays.fill(arr,-1);
        // }
        // return solve(n-1,m-1,word1,word2,dp);
        int[][] dp = new int[n+1][m+1];

        //base cases
        //when i < 0
        for(int j = 0; j <= m; j++){
            dp[0][j] = j; //not j+1 because of index shifting
        }
        //when j < 0
        for(int i = 0 ; i <= n ; i++){// j can be from 0 or 1 as it put dp[0][0] as 1 itself as done in previous loop
            dp[i][0] = i; //not i+1 because of index shifting
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insert,Math.min(replace,delete));
                }
            }
        }
        return dp[n][m];
    }
    private int solve(int i,int j,String s1,String s2,int[][] dp){
        // base cases
        if(i < 0) return j+1;//if s1 reaches end we need to insert all the remaining chars of s2
        if(j < 0) return i+1;//s2 reached the end we need to delete all the remaining chars

        if(dp[i][j] != -1) return dp[i][j];
        //try all possibilities on index
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(i-1,j-1,s1,s2,dp);
        }
        else{
            //-1-insert 
            //insert a charater of s2[j] in s1
            //s1 = horse and s2 = ros    'e' and 's' does not match 
            //insert 's' in s1
            //hypothetically -> s1 = horses
            //so i will remain same
            //j will change as as we forcefully matched character by adding
            int insert = 1 + solve(i , j-1 , s1 , s2 , dp);
            
            //-2- delete
            //s1 = hors after deleting 'e' 
            int delete = 1 + solve(i-1 , j , s1 , s2 , dp);

            //-3- replace
            //ater replacing
            //s2 = horss 
            int replace = 1 + solve(i-1 , j-1 , s1 , s2 , dp);

            return dp[i][j] = Math.min(insert,Math.min(replace,delete));
        }
    }
}
}
