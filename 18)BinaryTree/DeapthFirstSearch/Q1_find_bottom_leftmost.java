package DeapthFirstSearch;
//Question - Given the root of a binary tree, return the leftmost value in the last row of the tree.
/*
Example 1:
Input: root = [2,1,3]
Output: 1

Example 2:
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7

Example 3:
Input: root = [1,2,3,null,null,null,6,null,null]
Output = 6
 */

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
    //this question can also be solved using breadth first search
    //solver in Q1 of BFS folder
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
    //optimized
    class Solution2 {
        int maxDepth = 0;
        int maxValue = 0;
        public int findBottomLeftValue(TreeNode root) {
            recurse(root, 1);
            return maxValue;
        }
    
        public void recurse(TreeNode root, int depth) {
            if(maxDepth < depth) {
                maxValue = root.val;
                maxDepth = depth;
            }
            if(root.left != null) {
                recurse(root.left, depth+1);
            }
            if(root.right != null) {
                recurse(root.right, depth+1);
            }
        }
    }
}
