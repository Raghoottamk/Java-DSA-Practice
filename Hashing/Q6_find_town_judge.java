public class Q6_find_town_judge {
    //https://leetcode.com/problems/find-the-town-judge/description/
    class Solution {
        public int findJudge(int n, int[][] trust) {
            if(trust.length == 0 && n ==1) return 1;
            int[] hash = new int[n+1];
            
            for(int[] t : trust){
                hash[t[0]] = -1;
                if(hash[t[1]]== -1) continue;
                hash[t[1]]++;
            }
            for(int i = 0; i < n+1 ; i++){
                if(hash[i] == n-1) return i;;
            }
            return -1;
        }
    }
}
