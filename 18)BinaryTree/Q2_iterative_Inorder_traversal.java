import java.util.*;
public class Q2_iterative_Inorder_traversal {
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
        
        public static List<Integer> Inorder(Node root){
            List<Integer> list = new ArrayList<>();
            if(root == null){
                return list;
            }
            Stack<Node> s = new Stack<Node>();
            Node curr = root;
    
            // Traverse the tree
            while (curr != null || s.size() > 0){
                // Reach the left most Node of the
                // curr Node
                while (curr !=  null)
                {
                    // Place pointer to a tree node on
                    // the stack before traversing
                    // the node's left subtree
                    s.push(curr);
                    curr = curr.left;
                }
                // Current must be NULL at this point
                curr = s.pop();
                list.add(curr.data);
                // we have visited the node and its
                // left subtree. Now, it's right
                // subtree's turn
                curr = curr.right;
            }
            return list;
        }
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(17);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        System.out.println(tree.Inorder(tree.root));//10 8 3 5 2 2 
    }
}
