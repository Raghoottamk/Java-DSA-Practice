public class Q5_sorted_array_to_BST {
    
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return create_BST(nums,0,nums.length-1);
        }
        private TreeNode create_BST(int[] arr,int start, int end){
            if(start > end) return null;
            int mid = (start+end)/2;
            TreeNode root = new TreeNode(arr[mid]);
    
            TreeNode left = create_BST(arr,start,mid-1);
            TreeNode right = create_BST(arr,mid+1,end);
    
            root.left = left;
            root.right = right;
    
            return root;
        }
    }
}
