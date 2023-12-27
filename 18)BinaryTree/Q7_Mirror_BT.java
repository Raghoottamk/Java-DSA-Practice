import org.w3c.dom.Node;

public class Q7_Mirror_BT {
    class Node{
        int data;
        Node left, right;
        Node(int item){
            data = item;
            left = right = null;
        }
    }

    class Solution {
        // Function to convert a binary tree into its mirror tree.
        void mirror(Node node) {
            // Your code here
            helper(node);
        }
        private Node helper(Node root){
            if(root == null) return null;
            
            Node left = helper(root.left);
            Node right = helper(root.right);
            
            //swap
            root.left = right;
            root.right = left;
            
            return root;
        }
    }
    class Solution2 {
        // Function to convert a binary tree into its mirror tree.
        void mirror(Node node) {
            // Your code here
            if(node == null) return;
            mirror(node.left);
            mirror(node.right);
            
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
}
