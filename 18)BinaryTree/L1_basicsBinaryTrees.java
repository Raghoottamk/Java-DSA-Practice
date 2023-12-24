import java.util.*;

public class L1_basicsBinaryTrees {
    static  class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildBinaryTree(int[] nodes){
            ++idx;//so that it becomes 0 when called first
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildBinaryTree(nodes);
            newNode.right = buildBinaryTree(nodes);

            return newNode;
        }
        //traversal 
        //1st - preorder traversal root:left:right
        //TC = O(n), where n = no. of nodes
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
        
        public static void levelorder(Node root){
        //TC = O(2n)
        //SC = O(n)
            if(root == null){
                return ;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null) q.add(currNode.left);
                    if(currNode.right != null) q.add(currNode.right);
                }
            }
        }
        public static int height(Node root){
            //TC = O(n)
            //SC = O(h) where h is height of tree
            if(root == null) return 0;
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int max = Math.max(leftHeight,rightHeight) + 1;
            return max;
        }

        //Question - 1 -
        //count number of nodes in a tree
        public static int count(Node root){
            if(root == null) return 0;
            int leftcnt = count(root.left) ;
            int rightcnt = count(root.right);
            return leftcnt + rightcnt + 1;
        }
        //Question - 2 -
        //sum of all nodes in a tree
        public static int sum(Node root){
            if(root == null) return 0;
            int leftsum = sum(root.left);
            int rightsum = sum(root.left);
            return leftsum + rightsum + root.data; 
        }
        //Question - 3 -
        //maximum value of the node in tree
        public static int max(Node root){
            if(root == null) return 0;
            // int leftmax = max(root.left);
            // int rightmax = max(root.right);
            // int max = Math.max(leftmax,rightmax);
            // return Math.max(root.data,max);
            return Math.max(root.data,Math.max(max(root.left),max(root.right)));
        }
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(nodes);
        // System.out.println(root);//1
        // System.out.println(root.left.data);//2
        // System.out.println(root.left.left.data);//4
        // System.out.println(root.left.right.data);//5
        // System.out.println(root.right.data);//3
        //tree.preorder(root);//1 2 4 5 3 6 
        //tree.inorder(root);//4 2 5 1 3 6
        //tree.postorder(root);//4 5 2 6 3 1
        //tree.levelorder(root);
        /*
        level order output
        1 
        2 3 
        4 5 6
        */
        //System.out.println(tree.height(root));//3
        //System.out.println(tree.count(root));
        //System.out.println(tree.sum(root));
        System.out.println(tree.max(root));
    }
}
