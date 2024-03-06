//https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.PriorityQueue;

public class Q1_k_nearby_cars_or_points {
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]));
        for(int[] arr : points){
            pq.offer(arr);
        }
        int[][] result = new int[k][2];
        for(int i = 0; i < k;i++){
            result[i] = pq.poll();
        }
        return result;
    }
}
}