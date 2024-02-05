/*
--Question--
There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key. If either predecessor or successor is not found, then set it to NULL.
Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 

Example 1:
Input:
      8
    /   \
   1     9
    \     \
     4    10
    /
   3
key = 8 Output: 
4 9 Explanation: 
In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.

Example 2:
Input:
        10
      /   \
     2    11
   /  \ 
  1    5
      /  \
     3    6
      \
       4
key = 11 Output: 
10 -1 Explanation: 
In given BST, the inorder predecessor of 11 is 10 whereas it does not have any inorder successor.
 */
class Node{
    int data;
    Node left;
    Node right;
    Node(){}
    Node(int data){
        this.data = data;
    }
}
public class Q11_find_predecessor_successor_of_key_in_BST {

    static Node pre = new Node();
    static Node suc = new Node();

    public static void findPreSuc(Node root, int key){
    
        if(root == null) return ;
        
        
        if(root.data == key){
            //pre
            if(root.left != null){
                Node temp = root.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                pre = temp;
            }
            //suc
            if(root.right != null){
                Node temp = root.right;
                while(temp.left != null){
                    temp = temp.left;
                }
                suc = temp;
            }
            return;
        }
        if(root.data > key){
            suc = root;
            findPreSuc(root.left,key);
        }
        if(root.data < key){
            pre = root;
            findPreSuc(root.right,key);
        }
    }
}

