package QuestionOnShapes;

//https://leetcode.com/problems/valid-triangle-number/

//Approach- using two pointers
/*
    1-Sort the input array in non-decreasing order.
    2-Initialize a variable count to keep track of the number of valid triangles found.
    3-Iterate through the array from right to left, considering each element as the largest side of a potential triangle.
    4-For each element at index i, use two pointers (left and right) to find pairs of smaller sides that can form a valid triangle with the element at index i.
    5-If the sum of two smaller sides (pointed by left and right) is greater than the largest side (at index i), it forms a valid triangle with all elements between left and right.
    6-Increment count by the number of valid triangles found between left and right.
    7-Move the right pointer one step to the left if a valid triangle is found, else move left pointer one step to the right.
    8-Repeat steps 4-7 until all combinations are checked for each element as the largest side.
 */
import java.util.Arrays;

public class Q1_Valid_triangles {
    class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 0;
        for(int i = n-1; i >=2 ; i--){
            int left = 0;
            int right = i - 1;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    cnt += right - left;
                    right --;
                }else{
                    left++;
                }
            }
        }
        return cnt;
    }
}
}
