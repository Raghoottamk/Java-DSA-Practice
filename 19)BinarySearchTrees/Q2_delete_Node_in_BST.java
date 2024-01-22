 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Q2_delete_Node_in_BST {
    
    class Solution {
       public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) return root;
            if(root.val < key){
                root.right = deleteNode(root.right, key);
            }
            else if(root.val > key){
                root.left = deleteNode(root.left, key);
            }
            else{
                //root.val == key
                //case 1: no child exits for the node to be deleted
                //return null to the parent , garbage collector will automatically delete the node
                    if(root.left == null && root.right == null){
                        return null;
                    }
                //case 2: only one child exists
                //replace node with its child node
                    if(root.left == null){
                        return root.right;
                    }
                    else if(root.right == null){
                        return root.left;
                    }
                //case 3: both the child exists
                else{
                    //replace the value with its inorder successor i.e. next greater number
                    //delete the node of inorder successor
                    //note : inorder successsor has 0 or only 1 child
                    //inorder successor is the "leftmost Node in the right subtree"
                    TreeNode inorder_succ = find_inorder_successor(root.right);
                    //updation and deletion can be done by two mtds
                    //mtd1
                    // inorder_succ.left = root.left;
                    // return root.right;
                    //mtd2
                    root.val = inorder_succ.val;
                    root.right = deleteNode(root.right,inorder_succ.val);
                }
            }
            return root;
        }
        private TreeNode find_inorder_successor(TreeNode temp){
            while(temp.left != null){
                temp = temp.left;
            }
            return temp;
        }
    }
}
