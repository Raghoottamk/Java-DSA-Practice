import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.

Example 1:
Input: nums = [1,3,4,1,2,3,1]
Output: [[1,3,4,2],[1,3],[1]]
Explanation: We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.

Example 2:
Input: nums = [1,2,3,4]
Output: [[4,3,2,1]]
Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.
 */
public class Q3_arryto2D {
    class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
            int freq[] = new int[nums.length + 1];

            List<List<Integer>> ans = new ArrayList<>();
            for (int c : nums) {
                if (freq[c] >= ans.size()) {
                    ans.add(new ArrayList<>());
                }

                // Store the integer in the list corresponding to its current frequency.
                ans.get(freq[c]).add(c);
                freq[c]++;
            }

            return ans;
        }
    }
    class Solution2 {
        public List<List<Integer>> findMatrix(int[] nums) {
            
            List<List<Integer>> ans = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            // for (int num : nums) {
            //     map.put(num, map.getOrDefault(num, 0) + 1);
            // }
            for(int i = 0; i < nums.length;i++){
                int count = map.containsKey(nums[i]) ? map.get(nums[i]) : 0;
                map.put(nums[i], count + 1);
            }
            while (!map.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                List<Integer> toErase = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int f = entry.getKey();
                    int s = entry.getValue();
                    temp.add(f);
                    s--;
                    if (s == 0) {
                        toErase.add(f);
                    }
                    map.put(f, s);
                }
                ans.add(temp);
                for (int i : toErase) {
                    map.remove(i);
                }
            }

            return ans;
        }
    }
}
