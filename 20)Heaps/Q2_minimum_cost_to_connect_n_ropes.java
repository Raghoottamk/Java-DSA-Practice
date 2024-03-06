import java.util.PriorityQueue;

public class Q2_minimum_cost_to_connect_n_ropes {
    //https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
class Solution{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length ; i++){
            pq.offer(arr[i]);
        }
        long cost = 0;
        while(!(pq.size() == 1)){
            long ans1 = pq.poll();
            long ans2 = pq.poll();
            cost += ans1 + ans2;
            pq.offer(ans1 + ans2);
        }
        return cost ;
    }
}
}
