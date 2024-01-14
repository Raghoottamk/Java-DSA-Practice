public class Q24_Transform_to_sumTree {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }
    
    class Solution{
        public void toSumTree(Node root){
             //add code here.
            helper(root);
        }
        private int helper(Node root){
            
            if(root == null) return 0;
             
            int left = helper(root.left);
            int right = helper(root.right);
            
            int val = left + right + root.data;
            root.data = left + right;
            
            return val;
        }
    }
}
