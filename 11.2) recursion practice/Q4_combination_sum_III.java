import java.util.*;
/*
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
 */

public class Q4_combination_sum_III {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(1,k,n,ds,list);
        return list;
    }
    public static void solve(int num,int k,int n,List<Integer> ds,List<List<Integer>> list){
        //base
        if(ds.size() == k && n == 0){
            list.add(new ArrayList<>(ds));
        }
        for(int i = num;i <= 9;i++){
            ds.add(i);
            n -= i;
            solve(i+1,k,n,ds,list);
            ds.remove(ds.size() - 1);
            n += i;
        }
    }

    //complete recursive way
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> ds = new ArrayList<>();
            solve(1,0,k,n,ds,list);
            return list;
        }
        public void solve(int i,int sum,int k,int n,List<Integer> ds,List<List<Integer>> list){
            //base
            if(sum > n) return;
    
            if(k == 0){
                if(sum == n){
                    list.add(new ArrayList<>(ds));
                }
                return;
            }
    
            if(i == 10) return;
            sum += i;
            ds.add(i);
            solve(i+1,sum,k-1,n,ds,list);
            
            sum -= i;
            ds.remove(ds.size()-1);
            solve(i+1,sum,k,n ,ds,list);
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }
}
