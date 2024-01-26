import java.util.ArrayList;
import java.util.Collections;
class TreeNode {
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
public class Q8_merge_two_BST {
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            ArrayList<Integer> list3 = new ArrayList<>();
            inorder(root1,list1);
            inorder(root2,list2);
            list3.addAll(list1);
            list3.addAll(list2);
            Collections.sort(list3);
            /*
            optimized
            int i = 0, j = 0;
            while(i < list1.size() && j < list2.size() ){
                if(list1.get(i) <= list2.get(j)){
                    list3.add(list1.get(i));
                    i++;
                }
                else{
                    list3.add(list2.get(j));
                    j++;
                }
            }
            while(i < list1.size()){
                list3.add(list1.get(i++));
            }
            while(j < list2.size()){
                list3.add(list2.get(j++));
            }
             */
            return buildBST(list3 , 0 , list3.size() - 1);
        }
        private void inorder(TreeNode root,ArrayList<Integer> list){
            if(root == null) return;

            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
        private TreeNode buildBST(ArrayList<Integer> list,int start,int end){
            if(start > end) return null;
            int mid = (start + end) / 2;

            TreeNode root = new TreeNode(list.get(mid));
            root.left = buildBST(list,start,mid-1);
            root.right = buildBST(list,mid + 1, end);

            return root;
        }

    }
}
