import java.util.HashMap;
import java.util.Map;
/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */
public class Q32_Build_BT_from_inorder_postorder {

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
        TreeNode root = solve(preorder,0,preorder.length - 1,inorder,0,inorder.length -1,map);
        return root;
    }
    private TreeNode solve(int[] pre,int pstart,int pend,int[] in,int istart,int iend,Map<Integer,Integer> map){

        if(pstart > pend || istart > iend ) return null;

        TreeNode root = new TreeNode(pre[pstart]);
        int inRoot = map.get(root.val);
        int remainNums = inRoot - istart;
        root.left = solve(pre,pstart + 1,pstart + remainNums ,in,istart,inRoot - 1,map);
        root.right = solve(pre,pstart + remainNums + 1, pend, in, inRoot + 1, iend, map);
            
        return root;
    }
}
}