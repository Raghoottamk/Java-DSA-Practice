import java.util.ArrayList;

public class Q18_lowest_common_ancestor {
        //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        //helper function
        private boolean getPath(TreeNode root,TreeNode n,ArrayList<TreeNode> list){
            if(root == null) return false;
            
            list.add(root);

            if(root == n) return true;

            boolean findleft = getPath(root.left,n,list);
            boolean findright = getPath(root.right,n,list);

            if(!(findleft || findright)) {
                list.remove(list.size()-1);
                return false;
            }
            return true;
        }
        //main function
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            ArrayList<TreeNode> path1 = new ArrayList<>();
            ArrayList<TreeNode> path2 = new ArrayList<>();

            getPath(root, p, path1);
            getPath(root, q,path2);

            int i = 0;         
            while(i<path1.size() && i<path2.size()){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
                i++;
            }
            
            return path1.get(i-1);
        }
    }

    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return null;
    
            if(root.val == p.val || root.val == q.val) return root;
            //or it above statement can be written as - if(root == p || root == q.) return root;
            TreeNode leftLCA = lowestCommonAncestor(root.left,p,q);
            TreeNode rightLCA = lowestCommonAncestor(root.right,p,q);
    
            //situation where one of the val exists and another doesnot{
                if(leftLCA == null){
                    return rightLCA;
                }
                if(rightLCA == null){
                    return leftLCA;
                }
            //}
            //if(both exists) i.e if(leftLCA != null && rightLCA != null) return root;
            return root;//if(both exists) i.e if(leftLCA != null && rightLCA != null) return root;
        }
    }
    class Solution3 {
        //same as solution2 but well written
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q)  return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left != null && right != null)   return root;
            return left != null ? left : right;
        }
    
    }
    
}