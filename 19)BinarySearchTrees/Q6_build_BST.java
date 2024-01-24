import java.util.ArrayList;
/*
Question--
Given a Binary Search Tree, modify the given BST such that it is balanced and has minimum possible height. Return the balanced BST.

Example1:
Input:
       30
      /
     20
    /
   10
Output:
     20
   /   \
 10     30

Example2:
Input:
         4
        /
       3
      /
     2
    /
   1
Output:
      3            3           2
    /  \         /  \        /  \
   1    4   OR  2    4  OR  1    3   
    \          /                  \ 
     2        1                    4
 */
public class Q6_build_BST{
    class Solution {

        public TreeNode balanceBST(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            inorder_sequence(root,list);
            return buildBST(0,list.size()-1,list);
        }
        private void inorder_sequence(TreeNode root,ArrayList<Integer> list){
            if(root == null) return;
            inorder_sequence(root.left,list);
            list.add(root.val);
            inorder_sequence(root.right,list);
        }
        private TreeNode buildBST(int start,int end,ArrayList<Integer> list){
            if(start > end) return null;

            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(list.get(mid));

            root.left = buildBST(start,mid-1,list);
            root.right = buildBST(mid+1,end,list);

            return root;
        }
    }
}