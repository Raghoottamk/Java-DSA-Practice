import java.util.*;

public class Q3_iterative_postorder {
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
        // An iterative function to do postorder traversal
        // of a given binary tree
        /*
        Time Complexity: O(n)
        Auxiliary Space: O(n)
        Method 2: 
        Push directly root node two times while traversing to the left. 
        While popping if you find stack top() is same as root then go for root->right else print root.
         */
        public static List<Integer> postorder(Node root){
            List<Integer> list = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            while(true) {
                while(root != null) {
                    stack.push(root);
                    stack.push(root);
                    root = root.left;
                }
                
                // Check for empty stack
                if(stack.isEmpty()) return list;

                root = stack.pop();
                if(!stack.isEmpty() && stack.peek() == root) root = root.right;
                else {
                    list.add(root.data);
                    root = null;
                }
            }

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
 
        System.out.println("Post order traversal of binary tree is :");
        System.out.println(tree.postorder(tree.root));//[3, 5, 8, 2, 17, 10]
    }
}
