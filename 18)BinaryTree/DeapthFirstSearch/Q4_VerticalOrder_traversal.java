import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
/*
Question -
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.

Example 2:
Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.

Example 3:
Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 */
/*
Intuition - 
We need a way to traverse the tree while keeping track of each node's vertical column and horizontal row.
Organizing nodes by their column, and then by their row, allows us to get the vertical order.
For nodes on the same row and column, we sort by value.

Approach - 
Use Depth First Search (DFS) to traverse the tree, maintaining the current row and column.
Use a HashMap to map each column to a TreeMap. The TreeMap maps rows to PriorityQueues that store node values.
The TreeMap inherently sorts by row, while the PriorityQueue sorts node values.
After DFS, iterate through the columns in order, then the rows in order, and finally extract values from the PriorityQueue to build the result list.

Complexity -
Time complexity:
O(N log N): DFS traversal takes O(N), and the sorting operations using TreeMap and PriorityQueue lead to the log N factor.

Space complexity:
O(N): Even though we use multiple data structures (HashMap, TreeMap, and PriorityQueue), in the worst case, we will store each node in the tree once, leading to O(N) space.
 */
public class Q4_VerticalOrder_traversal {

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
        Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map;
        int min,max;
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            
            if(root == null) return new ArrayList<>();

            map = new HashMap<>();//global declared variable need to be cleared every time for running it successfully
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            dfs(root,0,0);

            List<List<Integer>> res = new ArrayList<>();
            for (int i = min; i <= max; i++) {
                List<Integer> innerList = new ArrayList<>();
                TreeMap<Integer, PriorityQueue<Integer>> treeMap = map.get(i);
                for (int row : treeMap.keySet()) {
                    PriorityQueue<Integer> pq = treeMap.get(row);
                    while (!pq.isEmpty()) {
                        innerList.add(pq.poll());
                    }
                }
                res.add(innerList);
            }
            return res;
        }
        public void dfs(TreeNode root,int row,int col){
            if(root == null) return;

            min = Math.min(min,col);
            max = Math.max(max,col);

            map.computeIfAbsent(col, k -> new TreeMap<>()).computeIfAbsent(row, k -> new PriorityQueue<>()).offer(root.val);
            
            //recursive call
            dfs(root.left , row+1 , col-1);
            dfs(root.right , row+1 , col+1);
        }
    }
}
