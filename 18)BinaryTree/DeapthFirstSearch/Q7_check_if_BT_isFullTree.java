package DeapthFirstSearch;
/*
--Question--
Given a Binary Tree. Check whether the Binary tree is a full binary tree or not.

Example 1:
Input:
          1
       /    \
      2      3
    /   \
   4     5
Output: 1
Explanation: Every node except leaf node
has two children so it is a full tree.

Example 2:
Input:
          1
       /    \
      2      3
    /   
   4     
Output: 0
Explanation: Node 2 has only one child
so this is not a full tree.
 */
public class Q7_check_if_BT_isFullTree {
class Node {
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
class GfG{
    // Return True if the given Binary Tree is a Full Binary Tree. Else return False
	boolean isFullTree(Node root)
    {
        //add code here.
        if(root == null) return true;
        boolean lt = isFullTree(root.left);
        boolean rt = isFullTree(root.right);
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left != null && root.right != null) {
            return isFullTree(root.left) && isFullTree(root.right);
        }
        
        return false;
    }
}
}
