import java.util.ArrayList;
import java.util.Collections;

public class Q9_add_node_into_BST {

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        list.add(val);
        Collections.sort(list);
        return BuildBST(list,0,list.size() - 1);
    }
    private void inorder(TreeNode root,ArrayList<Integer> list){
        if(root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    private TreeNode BuildBST(ArrayList<Integer> list,int start,int end){
        if(start > end) return null;
        int mid = start + (end - start) /2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = BuildBST(list,start,mid - 1);
        root.right = BuildBST(list,mid+1,end);
        return root;
    }
}
}