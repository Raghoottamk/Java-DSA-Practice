import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
https://leetcode.com/problems/find-k-closest-elements/description/
public class Q6_find_K_closet_elements {
class Solution {

    // Approach:
    // Using a min heap priority queue, add all the smallest integers up to k integers.
    // Then, traverse the 'arr' array will replacing the priority queue with integer closer to x.

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Traverse the array with,
        // First, add all the smallest integers up to k number.
        // Second, if found a closer integer to x, remove the smallest integer from the priority queue, and add the new integer.
        // This is because the smallest integer is always the further to x, if a larger number is closer to x.
        for (int val : arr) {
            if (k > 0) {
                minHeap.offer(val);
                k--;
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(val- x)) {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        
        // Add the integers from the priority queue to the result.
        // This will automatically add in ascending order, from smallest to largest k integers closest to x.
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}
}
