import java.util.ArrayList;

public class Q10_kth_smallest_in_BST {
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        if(list.size() == 1 && k == 1) return list.get(0); 
        for(int i = 1; i <= list.size() ; i++){
            if(i == k){
                return list.get(i-1);
            }
        }
        return -1;
    }
    private void inorder(TreeNode root,ArrayList<Integer> list){
        if(root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
}
