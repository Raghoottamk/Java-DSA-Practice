import java.util.*;

public class Q1_iterative_preorder_traveral {
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
        
        public static List<Integer> preorder(Node root){
            List<Integer> list = new ArrayList<>();
            if(root == null){
                return list;
            }
            Stack<Node> s = new Stack<>();
            s.push(root);
            /* Pop all items one by one. Do following for every popped item
            a) print it
            b) push its right child
            c) push its left child
            Note that right child is pushed first so that left is processed first 
            */
            while(!s.isEmpty()){
                Node curr = s.peek();
                list.add(curr.data);
                s.pop();
                // Push right and left children of the popped node to stack
                if (curr.right != null) {
                    s.push(curr.right);
                }
                if (curr.left != null) {
                    s.push(curr.left);
                }
            }
            return list;
        }

    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        System.out.println(tree.preorder(tree.root));//10 8 3 5 2 2 
    }
}
