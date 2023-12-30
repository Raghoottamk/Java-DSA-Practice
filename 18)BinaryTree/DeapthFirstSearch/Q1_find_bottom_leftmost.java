package DeapthFirstSearch;

public class Q1_find_bottom_leftmost {
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
        //depth firstsearch
        int leftVal = 0;
        public int height(TreeNode root){
            if(root == null) return 0;
               
            int rh = height(root.right);
            int lh = height(root.left);
       
            return 1 + Math.max(lh,rh);
        }
        public void leftMostVal(TreeNode root,int level,int height){
            if(root == null)
                return;
               
            if(height == level){
                leftVal = root.val;
                return;
            }
               
            leftMostVal(root.right, level+1, height);
            leftMostVal(root.left, level+1, height);
        }
        //main function
        public int findBottomLeftValue(TreeNode root) {
            int height = height(root);
            leftMostVal(root,1,height);
            return leftVal;
        }     
    }
}
