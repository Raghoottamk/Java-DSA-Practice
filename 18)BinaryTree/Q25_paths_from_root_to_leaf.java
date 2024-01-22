import java.util.ArrayList;
import java.util.List;

public class Q25_paths_from_root_to_leaf {
    /*
Given a Binary Tree of size N, you need to find all the possible paths from root node to all the leaf node's of the binary tree.

Example 1:
Input:
       1
    /     \
   2       3
Output: 1 2 #1 3 #
Explanation: 
All possible paths:
1->2
1->3

Example 2:
Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 10 20 40 #10 20 60 #10 30 #

Your Task:
Your task is to complete the function Paths() that takes the root node as an argument and return all the possible path. (All the path are printed '#' separated by the driver's code.)

Note: The return type
cpp: vector
java: ArrayList>
python: list of list

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
1<=N<=103.
*/
    class Node {
        int data;
        Node left, right;
        
        public Node(int data){
            this.data = data;
        }
    }
    class GFG{
        private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        public ArrayList<ArrayList<Integer>> Paths(Node root){
            // Code here
            helper(root,new ArrayList<>());
            return paths;
        }
        private void helper(Node root,ArrayList<Integer> path){
            if(root == null){
                return;
            }
            path.add(root.data);
            if(root.left == null && root.right == null){
                paths.add(new ArrayList<>(path));
            }
            helper(root.left,path);
            helper(root.right,path);
            path.remove(path.size()-1);
        }
        
    }
/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:
Input: root = [1]
Output: ["1"]
 */
    class TreeNode {
        int val;
        Node left, right;
        
        public TreeNode(int val){
            this.val = val;
        }
    }
    class leetcode {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<String>();
            if(root == null) return list;
            StringBuilder str = new StringBuilder();
            helper(root,list,str);
            return list;
        }
        public void helper(TreeNode root,List<String> list,StringBuilder str){
            if(root == null){
                //list.add(str.toString());
                return;
            }
            int length = str.length();
            if(length > 0){
                str.append("->");
            } 
            str.append(root.val);
            if(root.left == null && root.right == null){
                //reached leafNode
                list.add(str.toString());
            }
            helper(root.left,list,str);
            helper(root.right,list,str);
            // Restore the original path (backtrack) before exiting this node
            str.setLength(length);
        }
    }
}
