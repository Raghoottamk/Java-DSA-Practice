import java.util.ArrayList;
import java.util.List;

public class Q37_Two_sum_in_BST {

    class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int i = 0;
        int j = list.size()-1;
        
        while(i < j){
            if(list.get(i) + list.get(j) == k) return true;
            else if(list.get(i) + list.get(j) < k){
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }
    private void inorder(TreeNode root,List<Integer> list){
        if(root == null) return;
        
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
}