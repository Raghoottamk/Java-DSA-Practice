import java.util.*;

public class Q20_time_for_BT_infect_burn {
    //infect in leetcode burn in GFG
/*
Question:
You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
Each minute, a node becomes infected if:

The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.

 

Example 1:
Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.

Example 2:
Input: root = [1], start = 1
Output: 0
Explanation: At minute 0, the only node in the tree is infected so we return 0.
*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int x) { val = x; }
    }
    //solve using BFS
    class Solution {
        private Map<TreeNode,TreeNode> map = new HashMap();
        public int amountOfTime(TreeNode root, int start) {
            TreeNode start_infec = mapParent(root,start);
            int time = findTime(start_infec);
            return time;
        }

        private TreeNode mapParent(TreeNode root,int start){
            //this function maps all the child to their parent 
            //and find the start root
            TreeNode start_infec = new TreeNode();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                TreeNode curr = q.poll();
                if(curr.val == start) start_infec = curr;

                if(curr.left != null){
                    map.put(curr.left,curr);
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    map.put(curr.right,curr);
                    q.offer(curr.right);
                }
            }
            return start_infec;
        }
    }
    private int findTime(TreeNode start_infec){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(start_infec);
        Map<TreeNode,Integer> visited = new HashMap();
        visited.put(start_infec,1);
        int time = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            int flag = 0;
            for(int i = 0; i < sz ; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    flag = 1;
                    visited.put(curr.left,1);
                    q.offer(curr.left);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    flag = 1;
                    visited.put(curr.right,1);
                    q.offer(curr.right);
                }
                if(map.get(curr) != null && visited.get(map.get(curr)) == null){
                    flag = 1;
                    visited.put(map.get(curr),1);
                    q.offer(map.get(curr));
                }
            }
            if (flag == 1) time++;
        }
        return time;
    }
}
    //solve using DFS
    /*Approach 2(DFS)
    Tree Traversal:
    The traverse function performs a depth-first search (DFS) on the binary tree.
    It calculates the depth of the node with value start from the current node.
    If the current node is null, it returns 0.
    Recursively computes the left and right depths from the current node.
    Depth Calculation:

    When the node value matches the start value, it updates maxDistance with the maximum of left and right depths, indicating the distance of the farthest descendant.
    If both left and right subtrees are present, it calculates the depth based on the maximum depth between them plus 1.
    Otherwise, it computes the distance as the sum of absolute depths of left and right subtrees and updates maxDistance accordingly.
    Return Values:

    The depth variable is used to store the depth information of the current node being traversed.
    The maxDistance is updated during the traversal to maintain the maximum distance found so far.
    Return Result:

    The amountOfTime function initiates the traversal, updates maxDistance, and returns the computed maxDistance value.
    Complexity
    Time complexity:
    O(n)O(n)O(n)

    Space complexity:
    O(n)O(n)O(n)
*/
    class Solution {
        private int maxDistance = 0;
        private int depth = 0;
        public int amountOfTime(TreeNode root, int start) {
            traverse(root, start);
            return maxDistance;
        }

        private int traverse(TreeNode root, int start) {
            //int depth = 0; //if globally it was not declared,doesnot make any difference though
            if (root == null) {
                return depth;
            }

            int leftDepth = traverse(root.left, start);
            int rightDepth = traverse(root.right, start);

            if (root.val == start) {
                maxDistance = Math.max(leftDepth, rightDepth);
                depth = -1;
            } else if (leftDepth >= 0 && rightDepth >= 0) {
                depth = Math.max(leftDepth, rightDepth) + 1;
            } else {
                int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
                maxDistance = Math.max(maxDistance, distance);
                depth = Math.min(leftDepth, rightDepth) - 1;
            }

            return depth;
        }
    }
}
