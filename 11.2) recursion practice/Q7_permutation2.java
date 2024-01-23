import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
Question:
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 
Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10

 */
public class Q7_permutation2 {
    //brute force
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> list=new ArrayList<>(); 
            List<Integer>currlist=new ArrayList<>(); 
            HashMap<Integer,Integer> map=new HashMap<>();
            helper(nums,list,currlist,map); 
            return list;
        } 

        public static void helper(int []nums,List<List<Integer>> list, List<Integer> currlist,HashMap<Integer,Integer> map){
            if(currlist.size()==nums.length){ 
                if(!list.contains(currlist)){
                    list.add(new ArrayList<>(currlist));
                }
                return ;
            }  
            for(int j=0;j<nums.length;j++){ 
                if(!map.containsKey(j)){
                    map.put(j,1);
                    currlist.add(nums[j]); 
                    helper(nums,list,currlist,map);
                    currlist.remove(currlist.size()-1);
                    map.remove(j);
                }
            }
        }
    }
    //optimized
    class Solution2 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);
            backtrack4(list, new ArrayList<>(), nums, new boolean[nums.length]);
            return list;
        }

        private void backtrack4(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean []bool){
            if(tempList.size() == nums.length){
                list.add(new ArrayList<>(tempList));
                return;
            for(int i = 0; i < nums.length; i++){
                if(bool[i] || i > 0 && nums[i] == nums[i-1] && !bool[i - 1]) continue;
                bool[i] = true; 
                tempList.add(nums[i]);
                backtrack4(list, tempList, nums, bool);
                bool[i] = false; 
                tempList.remove(tempList.size() - 1);
            }
            
        }
    }
}
