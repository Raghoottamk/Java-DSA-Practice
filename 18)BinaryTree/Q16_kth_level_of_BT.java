import java.util.*;
public class Q16_kth_level_of_BT {
    // A Binary Tree Node
    static class Node {
        int data;
        Node left, right;
    }
    
    // Recursive function to print all
    // nodes of a Binary Tree at a
    // given level using DFS traversal
    static void printNodes(Node root, int level, int K){
        // Base Case
        if (root == null) {
        return;
        }
    
        // Recursive Call for the left subtree
        printNodes(root.left, level + 1, K);
    
        // Recursive Call for the right subtree
        printNodes(root.right, level + 1, K);
    
        // If current level is the required level
        if (K == level) {
        System.out.print(root.data+ " ");
        }
    }
    public static void printKthLevel(Node root, int k) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Node node = queue.remove();

                if (k == 0) {
                    System.out.println(node.data);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                size--;
            }

            k--;
        }
    }
}

