import java.util.ArrayList;
import java.util.PriorityQueue;
//https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
public class Q5_sort_k_sorted_array {
    //also called as nearly sorted array
class Solution{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();//min heap
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length ; i++){
            pq.offer(arr[i]);
            if(pq.size() > k){
                list.add(pq.poll());
            }
        }
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        return list;
    }
}
}
