import javax.swing.tree.TreeNode;

public class Q8_Maximum_PathSum{ 
    //Definition for a binary tree node.
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
        private static int pathsum;
        //helper 
        private static int helper(TreeNode root){
            if(root == null) return 0;

            int left = helper(root.left);
            int right = helper(root.right);
            int maxpath = Math.max(left,right) + root.val;

            pathsum = Math.max(pathsum , left + right + root.val);

            return maxpath;
        }
        public int maxPathSum(TreeNode root) {
            pathsum = Integer.MIN_VALUE;
            helper(root);
            return pathsum;
        }

    }
    class Solution1 {
        public int maxPathSum(TreeNode root) {
            int[] diam = new int[1];
            diam[0] = Integer.MIN_VALUE;
            diamSum(root,diam);
            return diam[0];
        }
        private int diamSum(TreeNode root,int[]diam){
            if(root == null) return 0;

            int left = Math.max(0,diamSum(root.left,diam));
            int right = Math.max(0,diamSum(root.right,diam));

            diam[0] = Math.max(diam[0], left + right + root.val);

            return Math.max(left, right) + root.val;
        }
}
}