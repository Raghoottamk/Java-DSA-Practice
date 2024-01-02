import java.util.ArrayList;
import java.util.List;

public class Q13_rightSideView_of_BT {
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            preorder(root, list, 0);
            return list;
        }
        public void preorder(TreeNode root,List<Integer> list,int height){
            if(root == null) return;

            if(height == list.size()){
                list.add(root.val);
            }
            preorder(root.right,list,height + 1);
            preorder(root.left,list,height + 1);
        }
        //for leftsideview
        // public void preorder(TreeNode root,List<Integer> list,int height){
        //     if(root == null) return;

        //     if(height == list.size()){
        //         list.add(root.val);
        //     }
        //     preorder(root.left,list,height + 1);
        //     preorder(root.right,list,height + 1);
        // }
    }
}
