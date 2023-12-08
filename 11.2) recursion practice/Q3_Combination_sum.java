import java.util.*;
/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

 */
public class Q3_Combination_sum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        solve(candidates,target,list,new ArrayList<>(),0);
        System.out.println(list);
        return list;
    }
    public static void solve(int[] candidates, int target,List<List<Integer>> list,List<Integer> tempList,int idx){
        //base
        if( target == 0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        else if(idx == candidates.length || target < 0){
            return;
        }
        //choice 1 pick
        tempList.add(candidates[idx]);
        target -= candidates[idx];
        solve(candidates,target,list,tempList,idx);
        //choice 2 not pick
        tempList.remove(tempList.size() -1);
        target += candidates[idx];
        solve(candidates,target,list,tempList,idx + 1);
    }
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7}; 
        int target = 7;
        combinationSum(candidates,target);
    }
}
