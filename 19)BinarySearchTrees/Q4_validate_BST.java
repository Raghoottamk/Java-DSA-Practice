public class Q4_validate_BST {

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
        public boolean isValidBST(TreeNode root) {
            TreeNode min = null,max = null;
            return helper(root,min,max);
        }
        private boolean helper(TreeNode root,TreeNode min,TreeNode max){
            if(root == null) return true;
            if(min != null && min.val >= root.val){
                return false;
            }
            if(max != null && max.val <= root.val){
                return false;
            }
            return helper(root.left,min,root) && helper(root.right,root,max);
        }
    }
}