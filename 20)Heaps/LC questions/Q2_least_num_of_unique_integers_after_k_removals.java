import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
public class Q2_least_num_of_unique_integers_after_k_removals {

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length ; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.values());
       
        while(k > 0 ){
            if(minHeap.isEmpty()) return 0;
            int val = minHeap.remove();
            k -= val;
        }
        if(k == 0){
            return minHeap.size();
        }
        return minHeap.size() + 1;
    }
}
}