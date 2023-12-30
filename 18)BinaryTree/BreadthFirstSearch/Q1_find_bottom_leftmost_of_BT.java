//Question - Given the root of a binary tree, return the leftmost value in the last row of the tree.
/*
Example 1:
Input: root = [2,1,3]
Output: 1

Example 2:
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7

Example 3:
Input: root = [1,2,3,null,null,null,6,null,null]
Output = 6
 */
import java.util.LinkedList;
import java.util.Queue;

class Q1_find_bottom_leftmost_of_BT {   
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        //breadth firstsearch
        public int findBottomLeftValue(TreeNode root) {
            
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int leftMostVal = 0;
            while(!q.isEmpty()){
                TreeNode curr = q.poll();
                leftMostVal = curr.val;
                if(curr.right != null)q.offer(curr.right);
                if(curr.left != null) q.offer(curr.left);
            }
            return leftMostVal;
        }
    }
}