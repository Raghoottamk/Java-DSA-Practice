import java.util.HashMap;
/*
--Question--
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]
 */
public class Q33_Build_BT_from_Inorder_postorder {

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;

        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i){
            map.put(inorder[i], i);
        }
        
        return solve(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1,map);
    }
    private TreeNode solve(int[] inorder, int is, int ie, int[] postorder,int ps, int pe,HashMap<Integer,Integer> map){
        if (ps>pe || is>ie) return null;

        TreeNode root = new TreeNode(postorder[pe]);

        int ri = map.get(postorder[pe]);
        root.left = solve(inorder, is, ri-1, postorder, ps,ps+ri-is-1, map);
        root.right = solve(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, map);
        
        return root;
    }
}
}