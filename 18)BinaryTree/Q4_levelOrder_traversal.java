import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 
public class Q4_levelOrder_traversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return list;

        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> sublist = new LinkedList<>();
            int num = q.size();

            for(int i = 0;i < num; i++){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                sublist.add(q.poll().val);
            }
            list.add(sublist);
        }

        return list;
    }
}
}
