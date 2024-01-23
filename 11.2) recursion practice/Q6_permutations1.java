import java.util.ArrayList;
import java.util.List;

public class Q6_permutations1 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            // Arrays.sort(nums); // not necessary as in any order can be returned
            backtrack3(list, new ArrayList<>(), nums);
            return list;
        }

        private void backtrack3(List<List<Integer>> list, List<Integer> tempList, int [] nums){
            if(tempList.size() == nums.length){
                list.add(new ArrayList<>(tempList));
                return;
            } else{
                for(int i = 0; i < nums.length; i++){ 
                    if(tempList.contains(nums[i])) continue; // element already exists, skip
                    tempList.add(nums[i]);
                    backtrack3(list, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        } 
    }
}