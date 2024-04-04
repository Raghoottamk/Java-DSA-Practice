import java.util.*;
public class Q1_1_LIS_using_binary_search {
    class Solution {

        public static int longestIncreasingSubsequence(int arr[]) {
            //Your code goes here
            int n = arr.length;
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[0]);
            int len = 1;
            for(int i = 1 ; i < n ; i++){
                if(arr[i] > temp.get(temp.size() - 1)){
                    temp.add(arr[i]);
                    len++;
                }
                else{
                    int ind = Collections.binarySearch(temp, arr[i]);
                    if(ind < 0){
                        //upperbound index is returned with negative value
                        //as we want lowebound we use -ind-1
                        ind = -ind - 1;
                    }
                    temp.set(ind,arr[i]);
                }
            }
            return len;
        }
    
    }
}
