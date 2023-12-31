import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class recursionAllPattern {
    //subsets
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack1(list, new ArrayList<>(), nums, 0);
    return list;
    }

    private void backtrack1(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack1(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    //Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack2(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    } 
    //Permutations : https://leetcode.com/problems/permutations/

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack3(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack3(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){ 
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack3(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    } 

    //Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack4(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack4(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean []bool){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
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
    //approach 2- hashmap
    public List<List<Integer>> permuteUnique2(int[] nums) {
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

    //Combination Sum : https://leetcode.com/problems/combination-sum/

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack5(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack5(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack5(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack6(list, new ArrayList<>(), nums, target, 0);
        return list;
        
    }

    private void backtrack6(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack6(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1); 
            }
        }
    } 

    //Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    } 
}
