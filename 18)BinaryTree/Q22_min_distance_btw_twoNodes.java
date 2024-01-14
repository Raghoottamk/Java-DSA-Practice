public class Q22_min_distance_btw_twoNodes {
/*
--Question--
Given a binary tree and two node values, a and b, your task is to find the minimum distance between them. The given two nodes are guaranteed to be in the binary tree and all node values are unique.
Example 1:
Input:
        1
      /  \
     2    3
a = 2, b = 3
Output: 2
Explanation: 
We need the distance between 2 and 3. Being at node 2, we need to take two steps ahead in order to reach node 3. The path followed will be: 2 -> 1 -> 3. Hence, the result is 2. 

Example 2:
Input:
        11
      /   \
     22  33
    /  \  /  \
  44 55 66 77
a = 77, b = 22
Output: 3
Explanation: 
We need the distance between 77 and 22. Being at node 77, we need to take three steps ahead in order to reach node 22. The path followed will be: 77 -> 33 -> 11 -> 22. Hence, the result is 3.
 */

    class Node{
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    } 

/* Should return minimum distance between a and b
   in a tree with given root*/
    class GfG {
        int findDist(Node root, int a, int b) {
            // Your code here
            Node node = LCA(root,a,b);
            int dist1 = LCAdist(node,a);
            int dist2 = LCAdist(node,b);
            
            return dist1+dist2;
        }
        private Node LCA(Node root,int a, int b) {
            if(root == null) return null;

            if(root.data == a || root.data == b) return root;
            //or it above statement can be written as - if(root == p || root == q.) return root;
            Node leftLCA = LCA(root.left,a,b);
            Node rightLCA = LCA(root.right,a,b);

            //situation where one of the val exists and another doesnot{
                if(leftLCA == null){
                    return rightLCA;
                }
                if(rightLCA == null){
                    return leftLCA;
                }
            //}
            
            return root;//if(both exists) i.e if(leftLCA != null && rightLCA != null) return root;
        }
        private int LCAdist(Node root,int n){
            if(root == null) return -1;
            if(root.data == n) return 0;
            
            int left = LCAdist(root.left,n);
            int right = LCAdist(root.right,n);
            //if(both are -1) return -1
            if(left == -1 && right == -1){
                return -1;
            }
            //if(only one of them return -1 then other side has found the node) return thatsideval+1; as we are going to pursue the val
            if(left == -1){
                return right+1;
            }
            if(right == -1){
                return left+1;
            }
            return -1;
        }
    }
}