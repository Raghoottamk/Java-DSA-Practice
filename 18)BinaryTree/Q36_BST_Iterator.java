import java.util.ArrayList;
import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/*
--Question--
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

Example 1:
Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False
 */
public class Q36_BST_Iterator {

class BSTIterator {
    //TC = O(1) for each method
    //SC = O(N) to store inorder in list
    private ArrayList<Integer> list = new ArrayList<>();
    private int i = 0;
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    public int next() {
        return list.get(i++);
    }
    
    public boolean hasNext() {
        return i < list.size();
    }
}
class BSTIterator2 {
    //TC = O(1)
    //SC = O(H) height of BST in stack
    private Stack<TreeNode> s = new Stack<>();
    private void pushAll(TreeNode root){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
    public BSTIterator2(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp = s.pop();
        if(temp.right != null){
            pushAll(temp.right);
        }
        return temp.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

}