import java.util.*;
public class Q10_boundary_traversal{
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public class Solution {
        //main function
        public static List<Integer> traverseBoundary(TreeNode root){
            // Write your code here.
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;
            if (isleaf(root) == false) list.add(root.data);
            leftboundary(root,list);
            leafboundary(root,list);
            rightboundary(root,list);   
            return list;
        }
        //problem divided in three parts
        //to check if node is leaf or not
        public static boolean isleaf(TreeNode root){
            return (root.left == null && root.right == null);
        }
        //part-1- add all the elements of left bondary unless its leaf
        public static void leftboundary(TreeNode root,List<Integer> list){
            TreeNode curr = root.left;
            while(curr != null){
                if(!isleaf(curr)) list.add(curr.data);
                if(curr.left != null)curr = curr.left;
                else curr = curr.right;
            }
        }
        //part-2- add all the elements of leaf node 
        public static void leafboundary(TreeNode root,List<Integer> list){
            if(isleaf(root)){
                list.add(root.data);
                return;
            }
            if(root.left != null)leafboundary(root.left,list);
            if(root.right != null)leafboundary(root.right,list);
        }
        //part-3- add all the elemenmts of the right boundary
        public static void rightboundary(TreeNode root,List<Integer> list){
            List<Integer> temp = new ArrayList<>();
            TreeNode curr = root.right;
            while(curr != null){
                if(!isleaf(curr)) temp.add(curr.data);
                if(curr.right != null)curr = curr.right;
                else curr = curr.left;
            }
            for(int i = temp.size()-1; i >= 0;i--){
                list.add(temp.get(i));
            }
        }
    }
}
