public class Q14_isSymmetric {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null) return true;
            return mirror(root.left,root.right);
        }
        public boolean mirror(TreeNode root1,TreeNode root2){
            if (root1 == null && root2 == null){
                return true;
            }
            if (root1 == null || root2 == null){
                return false;
            }
    
            return root1.val == root2.val && mirror(root1.left,root2.right) && mirror(root1.right,root2.left);
        }
    }
}
