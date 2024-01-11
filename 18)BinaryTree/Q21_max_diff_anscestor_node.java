//LC : 1089: maximum difference between node and ancestor
/*
Question:
Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

Example 1:
Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

Example 2:
Input: root = [1,null,2,null,0,3]
Output: 3
 */

public class Q21_max_diff_anscestor_node {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int x) { val = x; }
    }

    class Solution {
        private int max_diff;
        public int maxAncestorDiff(TreeNode root) {
            if(root == null) return 0;
            else if(root.left == null && root.right == null) return root.val;
            int min = root.val,max = root.val;
            helper(root,min,max);
            return max_diff;
        }
        public void helper(TreeNode root,int min,int max){
            if(root == null) return;
    
            max_diff = Math.max(max_diff,Math.max(Math.abs(min - root.val),Math.abs(max - root.val)));
            min = Math.min(min,root.val);
            max = Math.max(max,root.val);
            
            helper(root.left,min,max);
            helper(root.right,min,max);
        }
    }
}