package DeapthFirstSearch;

import java.util.*;
public class Q5_kth_levelOfBT {
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
    
}
