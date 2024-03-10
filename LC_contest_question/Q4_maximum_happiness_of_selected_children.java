import java.util.Arrays;
import java.util.PriorityQueue;

public class Q4_maximum_happiness_of_selected_children {
    //using priorityQueue
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2) -> p2 - p1);
        for(int i = 0; i < happiness.length ; i++){
            pq.offer(happiness[i]);
        }

        long res = 0;
        int turn = 0;

        while(!pq.isEmpty() && k-- > 0){
            int sol = pq.poll();
            sol -= turn;
            if(sol > 0){
                res += sol;
            }
        turn++;
        }
        return res;
    }  
}
//using sorting
class Solution2 {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int turn = 0;
        for(int i = happiness.length - 1; i >= 0; i--){
            if(k-- > 0 && happiness[i] - turn >= 0){
                res += happiness[i] - turn ;
                turn++;
            }
        }
        return res;
    }
}
}
