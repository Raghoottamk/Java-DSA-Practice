public class Q38_recover_BST {
/*
--Question--
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 */
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
           private TreeNode prev;
           private TreeNode first;
           private TreeNode mid;
           private TreeNode sec;
           private void inorder(TreeNode root){
               if(root == null) return;
               inorder(root.left);
       
               //if voilation occurs
               if(prev != null && (root.val < prev.val)){
                   //if first voilation occurs
                   if(first == null){
                       first = prev;
                       mid = root;
                   }
                   //second violation has also occured
                   else{
                       sec = root;
                   }
               }
               prev = root;
       
               inorder(root.right);
           }
           public void recoverTree(TreeNode root) {
               if(root == null) return;
               inorder(root);
       
               //when both voilation has occured
               if(first != null && sec != null){
                   //swap both the violated nodes
                   int temp = first.val;
                   first.val = sec.val;
                   sec.val = temp;
               }
               //when only one violation has occured
               else if(first != null && sec == null){
                   //swap the first with mid
                   int temp = first.val;
                   first.val = mid.val;
                   mid.val = temp;
               }
           }
       }
}