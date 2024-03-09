import java.util.PriorityQueue;

public class Q3_weakest_soldier {
//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
    class Pair implements Comparable<Pair>{
        int idx;
        int ones;
        Pair(int idx,int ones){
            this.idx = idx;
            this.ones = ones;
        }
        @Override
        public int compareTo(Pair p2){
            if(this.ones == p2.ones){
                return this.idx - p2.idx;
            }else{
                return this.ones - p2.ones;
            }
        }
    }
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for(int i = 0; i < mat.length; i++){
                int cnt = count1s(mat[i]);
                pq.offer(new Pair(i,cnt));
            }
    
            int[] result = new int[k];
            for(int i = 0; i < k ; i++){
                result[i] = pq.poll().idx;
            }
            return result;
        }
        private int count1s(int[] arr){
            int cnt = 0;
            for(int i = 0; i < arr.length ; i++){
                if(arr[i] == 0) break;
                ++cnt;
            }
            return cnt;
        }
    }
}