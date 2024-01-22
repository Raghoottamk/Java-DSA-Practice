public class Q3_range_sum_BST {
    class TreeNode {
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
        private int ans = 0;
        public int rangeSumBST(TreeNode root, int low, int high) {
            helper(root,low,high);
            return ans;
        }
        private void helper(TreeNode root,int low,int high){
            if(root == null) return;
            if(root.val >= low && root.val <= high){
                helper(root.left,low,high);
                ans += root.val;
                helper(root.right,low,high);
            }
            else if(root.val > high){
                helper(root.left,low,high);
            }
            else{
                //else if(root.val < low) 
                helper(root.right,low,high);
            }
        }
    }
}