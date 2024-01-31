/*
--Question--
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

Example 2:
Input: root = [1], target = 1, k = 3
Output: []
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Q31_All_nodes_at_distance_k_from_targetNode {

    class Solution {
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        markParents(root,parent);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(level == k) break;
            level++;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent.get(curr) != null && visited.get(parent.get(curr)) == null){
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
    }
    private void markParents(TreeNode root,Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) {
                    q.offer(curr.left);
                    parent.put(curr.left,curr);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                    parent.put(curr.right,curr);
                }
            }
        }
    }
}
}