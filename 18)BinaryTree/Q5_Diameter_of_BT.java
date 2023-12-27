import java.util.*;

import javax.swing.tree.TreeNode;

public class Q5_Diameter_of_BT {

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
    class Solution1 {
        public int diameterOfBinaryTree(TreeNode root) {
            return diameter(root) - 1;
            //ATQ we should return the diameter completely including left and right part but without counting the node so -1
        }
        //TC - O(n^2)
        public int diameter(TreeNode root){
            if(root == null) return 0;
            int leftDiam = diameter(root.left);
            int lh = height(root.left);
            int rightDiam = diameter(root.right);
            int rh = height(root.right);
    
            int selfdiam = lh + rh + 1;
    
            return Math.max(selfdiam,Math.max(leftDiam,rightDiam));
        }
        public int height(TreeNode root){
            if(root == null) return 0;
            int lh = height(root.left);
            int rh = height(root.right);
    
            return Math.max(lh,rh) +1;
        }
    }
    

    class Solution2 {
        //TC-O(n)
        //helper class
        private class Info{
            int ht;
            int diam;
            Info(int ht,int diam){
                this.ht = ht;
                this.diam = diam;
            }
        }
        //helper function
        private Info diameter_height(TreeNode root){
            if(root == null) return new Info(0,0);

            Info l_info = diameter_height(root.left);
            Info r_info = diameter_height(root.right);

            int diam = Math.max(Math.max(l_info.diam,r_info.diam),l_info.ht + r_info.ht + 1);
            int ht = Math.max(l_info.ht , r_info.ht) + 1;

            return new Info(ht,diam);
        }
        //main function of leetcode
        public int diameterOfBinaryTree(TreeNode root) {
            return diameter_height(root).diam -1;
        }
    }
    class Solution3 {
        public int diameterOfBinaryTree(TreeNode root) {
            int[] diameter = new int[1];
            height(root, diameter);
            return diameter[0];        
        }
    
        private int height(TreeNode node, int[] diameter) {
            if (node == null) {
                return 0;
            }
            int lh = height(node.left, diameter);
            int rh = height(node.right, diameter);
            diameter[0] = Math.max(diameter[0], lh + rh);
            return 1 + Math.max(lh, rh);
        }
    }
}
