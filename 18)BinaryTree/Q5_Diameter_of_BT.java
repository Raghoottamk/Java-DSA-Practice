import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q5_Diameter_of_BT {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static class BinaryTree{
        Node root;
        public static int height(Node root){
            if(root == null) return 0;
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
        public static int diameter(Node root){
            if(root == null) return 0;
            int leftdiameter = diameter(root.left);
            int rightdiameter = diameter(root.right);
            int leftHeight = height(root.left);

            
            int rightHeight = height(root.right);

            int selfdiameter = leftHeight + rightHeight + 1;//including itself in diameter

            return Math.max(selfdiameter,Math.max(rightdiameter, leftdiameter));
        }
    }
    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(17);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
 
        System.out.println(tree.height(tree.root));
        System.out.println(tree.diameter(tree.root));
    }
}
