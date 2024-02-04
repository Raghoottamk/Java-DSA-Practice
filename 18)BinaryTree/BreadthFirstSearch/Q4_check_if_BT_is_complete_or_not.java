import java.util.LinkedList;
import java.util.Queue;
/*
--Question--
Given the root of a binary tree, determine if it is a complete binary tree.
In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example 1:
Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.

Example 2:
Input: root = [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.
 */
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;this.left = left; this.right = right;
    }
}
public class Q4_check_if_BT_is_complete_or_not {
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < q.size(); ++i){
                TreeNode curr = q.poll();
                if(curr == null && !q.isEmpty()){
                    //check if all the things are null
                    while(!q.isEmpty()){
                        if(q.poll() != null) return false;
                    }
                    return true;
                }
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return true;
    }
}
}
