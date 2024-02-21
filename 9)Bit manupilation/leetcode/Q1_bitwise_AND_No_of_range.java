public class Q1_bitwise_AND_No_of_range {

    //https://leetcode.com/problems/bitwise-and-of-numbers-range/description/

    //brute force
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int ans = left;
            if(left == right) return left;
            for(int i = left + 1 ; i <= right ; i++){
                if(i==right){
                    ans = ans & i;
                    break;
                }
                if(ans == 0) return 0;
                ans = ans & i;
            }
            return ans;
        }
    }

    //Optimized
    /*
step-1- Common Prefix Identification:
    The function iteratively right-shifts both left and right until they become equal, identifying the common prefix of their binary representations.

step-2- Counting Shifts:
    It counts the number of right-shifts performed, storing the count in the variable cnt.

step-3- Bitwise AND Calculation:
    After finding the common prefix, it reconstructs the bitwise AND result by left-shifting the common prefix by cnt bits.
     */
    class Solution2 {
        public int rangeBitwiseAnd(int left, int right) {
            int count = 0;
            while(left != right){
                left >>= 1;
                right >>= 1;
                count++;
            }
            return (left << count);//or return (right << count);//as both will be same
        }
    }
}