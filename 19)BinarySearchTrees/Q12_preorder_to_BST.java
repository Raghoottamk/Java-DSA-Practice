/*
--Question--
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

Example 1:
Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Example 2:
Input: preorder = [1,3]
Output: [1,null,3]
 */
public class Q12_preorder_to_BST {
    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            return solve(preorder,0,preorder.length - 1);
        }
        private TreeNode solve(int[] pre,int start,int end){
            if(start > end) return null;
            
            TreeNode root = new TreeNode(pre[start]);
            int i;
            for(i = start; i <= end; i++){
                if(pre[i] > root.val)
                break;
            }
            root.left = solve(pre, start + 1,i - 1);
            root.right = solve(pre,i,end);
    
            return root;
        }
    }
}
