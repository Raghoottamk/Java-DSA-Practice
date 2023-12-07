import java.util.ArrayList;
import java.util.List;

public class Q14_PowerSet {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        solve(0,list,subset,nums);
        return list;
    }
    public static void solve(int i,List<List<Integer>> list,List<Integer> subset,int[] nums){
        if(i == nums.length){
            list.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        solve(i+1,list,subset,nums);
        subset.remove(subset.size()-1);
        solve(i+1,list,subset,nums);
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(subsets(nums));
    }
}
