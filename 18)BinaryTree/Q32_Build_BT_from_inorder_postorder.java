import java.util.HashMap;
import java.util.Map;

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