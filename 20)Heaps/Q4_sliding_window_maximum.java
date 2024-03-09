import java.util.ArrayList;
import java.util.PriorityQueue;
//https://leetcode.com/problems/sliding-window-maximum/
public class Q4_sliding_window_maximum {
class Pair{
    int val;
    int idx;
    Pair(int val , int idx){
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        //or
        //int[] res = new int[numsl.length - k+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> p2.val - p1.val);//max heap as we require max among the window
        //first window
        for(int i= 0 ; i < k; i++){
            pq.offer(new Pair(nums[i],i));
        }
        res.add(pq.peek().val);//first winodw ans
        //res[0] = pq.peek().val

        //next successive window
        for(int i = k ; i < nums.length ; i++){
            while(!(pq.isEmpty()) && pq.peek().idx <= (i-k)){
                pq.poll();
            }
            pq.offer(new Pair(nums[i],i));
            res.add(pq.peek().val);
            //res[i-k+1] = pq.peek().val;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
}
