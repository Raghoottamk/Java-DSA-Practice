import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q37_Two_sum_in_BST {
//TC = O(n)
//SC = O(n)
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

//optimal approach
//TC = O(n)
//sc = o(H) where he is height of a tree
class BSTIterator {
    private Stack<TreeNode> s = new Stack<>();
    boolean rev = true;

    private void pushAll(TreeNode root){
        while(root != null){
            s.push(root);
            if(rev == true){
                root = root.right;
            }
            else root = root.left;
        }
    }
    public BSTIterator(TreeNode root,boolean isreverse) {
        rev = isreverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp = s.pop();
        if(rev == false){
            pushAll(temp.right);
        }
        else pushAll(temp.left);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}
class Solution2 {
    public boolean findTarget(TreeNode root, int k) {
        if(root== null)return false;
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
}