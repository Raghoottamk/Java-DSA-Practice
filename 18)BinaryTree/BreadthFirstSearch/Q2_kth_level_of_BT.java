package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_kth_level_of_BT {
    // A Binary Tree Node
    static class Node {
        int data;
        Node left, right;
    }
    //level order travaersal
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
