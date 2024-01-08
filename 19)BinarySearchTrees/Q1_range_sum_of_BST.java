public class Q1_range_sum_of_BST {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }
    //brute force:
    //solving just like binary tree without considering the application of BST
    class Solution {
        static int ans;
        public int rangeSumBST(TreeNode root, int low, int high) {
            ans = 0;
            helper(root,low,high);
    
            return ans;
        }
        public void helper(TreeNode root,int low ,int high){
            if(root == null) return;
            if(root.val >= low && root.val <= high){
                ans += root.val;
            }
            
            helper(root.left,low,high);
            helper(root.right,low,high);
        }
    }

    //solving using the uses of traversing BST
    class Solution2 {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }
    
            // If the current node's value is within the range, add it to the sum
            int sum = 0;
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
    
            // Recursively explore the left and right subtrees if they can possibly contain values in the range
            if (root.val > low) {
                sum += rangeSumBST(root.left, low, high);
            }
            if (root.val < high) {
                sum += rangeSumBST(root.right, low, high);
            }
    
            return sum;
        }
    }
}