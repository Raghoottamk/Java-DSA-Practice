package DeapthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q6_kth_largest_sum_BT {
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
    class Solution2 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        
        ArrayList<Long>maxArray=new ArrayList<>();
        //PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        //priority queue approach giving bug solve using it later

        while(!q.isEmpty()){
            int count=q.size();
            long sum = 0;

            for(int i=0;i<count;i++){
                TreeNode cur=q.poll();
                sum += cur.val;
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }   
            }
            maxArray.add(sum); 
            //pq.add(sum);
        }
        if(k>maxArray.size()) return -1;
        Collections.sort(maxArray);
        return maxArray.get(maxArray.size()-k);
        // if(k > pq.size()) return -1;
        // return pq.peek();
    }
}
}
