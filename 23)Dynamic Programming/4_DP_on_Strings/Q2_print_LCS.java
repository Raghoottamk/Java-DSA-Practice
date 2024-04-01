public class Q2_print_LCS {
    //https://www.codingninjas.com/studio/problems/print-longest-common-subsequence_8416383?leftPanelTabValue=PROBLEM
    public static String findLCS(int n, int m, String s1, String s2){
        // Write your code here.
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){//hshifting of indices
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    int m1 = dp[i-1][j];
                    int m2 = dp[i][j-1];
                    dp[i][j] = Math.max(m1,m2);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n,j = m;
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i = i - 1;
            }
            else{
                //if dp[i-1][j] == dp[i][j-1] , we can move anywhere i-1 or j-1 ,here we are moving j - 1
                j = j - 1;
            }
        }
        return String.valueOf(sb.reverse());
    }
}
