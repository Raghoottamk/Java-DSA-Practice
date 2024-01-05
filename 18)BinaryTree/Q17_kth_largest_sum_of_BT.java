import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q17_kth_largest_sum_of_BT {
 
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
    //DFS
    class Solution {
        public long kthLargestLevelSum(TreeNode root, int k) {
            List<Long> levelSum =  new ArrayList<>();
            traverseTree(root, 0, levelSum);
            if (levelSum.size() < k) {
                return -1;
            }
            Collections.sort(levelSum);
            return levelSum.get(levelSum.size() - k);
        }

        private void traverseTree(TreeNode node, int level, List<Long> levelSum) {
            if (node == null) {
                return;
            }
            if (level == levelSum.size()) {
                levelSum.add(0L);//0 in long format
            }
            levelSum.set(level , levelSum.get(level) + node.val);
            traverseTree(node.left, level +1, levelSum);
            traverseTree(node.right, level +1, levelSum);
        }
    }
}
