public class Q_9_count_moves_to_move_all_balls {
    //https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/
    //brute force
    class Solution {
        public int[] minOperations(String boxes) {
            int n = boxes.length();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i == j) continue;
                    if(boxes.charAt(j) == '1'){
                        arr[i] += Math.abs(i-j);
                    }
                }
            }
            return arr;
        }
    }
    class Solution2 {
        public int[] minOperations(String boxes) {
            int n = boxes.length();
            int[] ltsum = new int[n];
            int[] rtsum = new int[n];
            int[] nums = new int[n];
            int x = Character.getNumericValue(boxes.charAt(0));
            for(int i = 1; i < n ; i++){
                ltsum[i] = ltsum[i-1]+x;
                if(boxes.charAt(i) == '1'){
                    x += 1;
                }
            }
            int y = Character.getNumericValue(boxes.charAt(n-1));
            for(int i = n-2; i > -1; --i){
                rtsum[i] = rtsum[i+1]+y;
                if(boxes.charAt(i) == '1'){
                    y+= 1;
                }
            }
            for(int i = 0; i < n ; i++){
                nums[i] = ltsum[i]+rtsum[i];
            }
            return nums;
        }
    }
}
