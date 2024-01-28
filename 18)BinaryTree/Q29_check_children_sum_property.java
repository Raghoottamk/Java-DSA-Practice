public class Q29_check_children_sum_property {
/*
--Question--
Given a Binary Tree. Check whether all of its nodes have the value equal to the sum of their child nodes.

Example 1:
Input:
     10
    /
  10 
Output: 
1
Explanation: 
Here, every node is sum of its left and right child.

Example 2:
Input:
       1
     /   \
    4     3
   /  \
  5    N
Output: 
0
Explanation: Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given conditions.
 */
class Tree{
    public static int isSumProperty(Node root){
        // add your code here
        int left = 0, right = 0;
 
    
        if (root == null || (root.left == null && root.right == null))
            return 1;
        else {
 
            if (root.left != null)
                left = root.left.data;
 
            if (root.right != null)
                right = root.right.data;
 
            if ((root.data == left + right) && (isSumProperty(root.left) == 1) && isSumProperty(root.right) == 1)
                return 1;
            else
                return 0;
        }
        
    }
}
}
