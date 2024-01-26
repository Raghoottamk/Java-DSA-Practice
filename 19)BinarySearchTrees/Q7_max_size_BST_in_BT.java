/*
-- Question --

Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:
Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1

Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.

Example 2:

Input: 6 6 3 N 2 9 3 N 8 8 2
            6
        /       \
       6         3
        \      /   \
         2    9     3
          \  /  \
          8 8    2 
Output: 2

Explanation: The following sub-tree is a
BST of size 2: 
       2
    /    \ 
   N      8
   
 */
public class Q7_max_size_BST_in_BT {
    class Node{ 
        int data; 
        Node left, right; 
    
        public Node(int d){ 
            data = d; 
            left = right = null; 
        } 
    }


    class Solution{
        
        // Return the size of the largest sub-tree which is also a BST
        private int max_size = 0;
        
        private class Info{
            boolean isBST;
            int size;
            int min;
            int max;
            Info(boolean isBST,int size,int min, int max){
                this.isBST = isBST;
                this.size = size;
                this.min = min;
                this.max = max;
            }
        }
        public int largestBst(Node root){
            // Write your code here
            solve(root);
            return max_size;
        }
        private Info solve(Node root){
            if(root == null) return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
            
            Info lt = solve(root.left);
            Info rt = solve(root.right);
            
            int size = lt.size + rt.size + 1;
            int min = Math.min(root.data,Math.min(lt.min,rt.min));
            int max = Math.max(root.data,Math.max(lt.max,rt.max));
            
            if(root.data <= lt.max || root.data >= rt.min){
                return new Info(false,size,min,max);
            }
            if(lt.isBST && rt.isBST){// && root is valid as root invalid conditation is checked before
                max_size = Math.max(max_size,size);
                return new Info(true,size,min,max);
            }
            return new Info(false,size,min,max);
        }
    }
}
