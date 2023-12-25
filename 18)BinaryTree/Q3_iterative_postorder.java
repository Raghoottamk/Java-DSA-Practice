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
        public static List<Integer> postorder1(Node root){
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
        //using 2 stacks
        public static List<Integer> postorder2(Node root){
            List<Integer> list = new ArrayList<>();
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            if(root == null) return list;
            s1.push(root);
            while(!s1.isEmpty()){
                root = s1.pop();
                s2.add(root);
                if(root.left != null) s1.push(root.left);
                if(root.right != null) s1.push(root.right);
            }
            while(!s2.isEmpty()){
                list.add(s2.pop().data);
            }
            return list;
        }
        //using 1 stack
        public static List<Integer> postorder3(Node root){
            List < Integer > list = new ArrayList < > ();
            if (root == null) return list;

            Stack < Node > st = new Stack < > ();
            while (root != null || !st.isEmpty()) {

                if (root != null) {
                    st.push(root);
                    root = root.left;
                } else {
                    Node temp = st.peek().right;
                    if (temp == null) {
                        temp = st.peek();
                        st.pop();
                        list.add(temp.data);
                        while (!st.isEmpty() && temp == st.peek().right) {
                            temp = st.peek();
                            st.pop();
                            list.add(temp.data);
                        }
                    } else root = temp;
                }
            }
            return list;
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
        System.out.println(tree.postorder1(tree.root));//[3, 5, 8, 2, 17, 10]
    }
}
