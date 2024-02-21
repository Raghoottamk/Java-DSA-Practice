import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/meeting-rooms-iii/?envType=daily-question&envId=2024-02-18
public class Q3_MeetingIII {

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //in busy pq -> int[] stores endtime at 0th index and room no. at 1st index
        PriorityQueue<Integer> idle = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            idle.offer(i);
        }

        int[] cnt = new int[n];

        for (var v : meetings) {
            int s = v[0] , e = v[1];//start and end timings of meetings
            while(!busy.isEmpty() && busy.peek()[0] <= s){//<= coz at meeting one meeting can end and another can start at same time
                //above condition means there are/is rooms which will get empty by the time it present meeting gets started
                //which means we need to push those rooms to idle
                idle.offer(busy.poll()[1]);
            }
            //inter-linking attribute between cnt[] and idle->pq and busy->pq that is room n0.
            //let room n0. be represented by i
            int i = 0;
            if(!idle.isEmpty()){
                //if there is empty room available then no need to change the end value while pushing it to busy->pa
                i = idle.poll();//assign meeting to empty room
                busy.offer(new int[]{e,i});
            }else{
                //no rooms available
                //then we need to alter the timings 
                int[] x = busy.poll();
                i = x[1];//room no. of room which gets emptied by the earliest
                busy.offer(new int[]{ x[0] + e-s , i});//ending time is delayed by(time required for room to get emptied + e -s)
            }
            cnt[i]++;//usage of room is increased by one
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if(cnt[ans] < cnt[i]){
                ans = i;
            }
        }
        return ans;
    }
}
}