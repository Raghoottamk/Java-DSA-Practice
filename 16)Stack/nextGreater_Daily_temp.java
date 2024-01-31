/*
--Question--
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 */

import java.util.Stack;

public class nextGreater_Daily_temp {

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //next greater element

        Stack<Integer> s = new Stack<>();
        s.push(temperatures.length - 1);
        int[] warm = new int[temperatures.length];
        warm[temperatures.length - 1] = 0;
        for(int i = temperatures.length-2 ; i >= 0; i--){
            int num = temperatures[i];
            while(!s.isEmpty() && num >= temperatures[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                warm[i] = 0;
            }
            else{
                warm[i] = s.peek() - i;
            }
            s.push(i);
        }
        return warm;
    }
}
}