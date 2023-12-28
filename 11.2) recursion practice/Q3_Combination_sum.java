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
/*
the difference b/w list.add(new ArrayList<>(tempList)); and list.add(tempList);
Key Difference:

In the correct code:

The line list.add(new ArrayList<>(tempList)); creates a new copy of the temporary list tempList before adding it to the final result list list.
In the code with the bug:

The line list.add(tempList); directly adds the reference to the temporary list tempList to the final result list list.
Why This Difference Causes the Bug:

The solve function recursively modifies the tempList as it explores different combinations.
When a reference to tempList is added to the list without copying, subsequent modifications to tempList in the recursion also affect the elements already added to list.
This leads to incorrect combinations being stored in the final result list list.
Example:

Consider candidates = [2, 3] and target = 5.
The correct code would produce list = [[2, 3], [3, 2]], two distinct combinations.
The code with the bug would produce list = [[2, 3, 2]], an incorrect combination due to modification of the referenced list.
Correction:

Always create a new copy of the temporary list when adding it to the final result list to ensure that each combination is independent and unaffected by subsequent recursive calls.
Additional Insights:

This bug highlights the importance of understanding reference vs. value semantics in programming languages.
Creating copies of objects is crucial when you want to preserve their state and avoid unintended modifications.
Thorough testing with various inputs can help catch similar issues in code that involves recursion and object manipulation.
 */
