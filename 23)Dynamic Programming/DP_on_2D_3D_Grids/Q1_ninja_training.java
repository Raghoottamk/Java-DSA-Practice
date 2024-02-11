import java.util.*;
public class Q1_ninja_training {
/*
--Question--
Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?
You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

For Example
If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
 */
//memoization
class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,3,points,dp);//passing non existent index in first call so that it considers all cases from i=0 ; i<=2
    }
    static int f(int day, int last, int[][] points, int[][] dp) {
        // If the result is already calculated, return it
        if (dp[day][last] != -1) return dp[day][last];

        // Base case: When it's the first day (day == 0)
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi; // Store and return the result
        }

        int maxi = 0;
        // Loop through the three activities on the current day
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                // Calculate the points for the current activity and recursively
                // calculate the maximum points for the previous day
                int activity = points[day][i] + f(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity); // Update the maximum points
            }
        }

        return dp[day][last] = maxi; // Store and return the result
    }
}
class solution2{
    //tabulation
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for(int day = 1; day < n ; day++){
            for(int last = 0; last< 4; last++){
                dp[day][last] = 0;
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity); 
                    }
                }
            }
        }
        return dp[n-1][3];//passing non existent index in first call so that it considers all cases from i=0 ; i<=2
    }
}
class solution3{
    public static int ninjaTraining(int n, int points[][]) {
        int[]prev  = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for(int day = 1; day < n ; day++){
            int temp[] = new int[4];
            for(int last = 0; last< 4; last++){
                temp[last] = 0;
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        int activity = points[day][task] + prev[task];
                        temp[last] = Math.max(temp[last], activity); 
                    }
                }
            }
            prev = temp;
        }
        return prev[3];//passing non existent index in first call so that it considers all cases from i=0 ; i<=2
    }
}
}