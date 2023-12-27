public class Q6_check_subtree_of_tree {
    public static class TreeNode {
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
    public static boolean isSubtree(TreeNode root,TreeNode subroot){
        if(root == null) return false;//given subroot != null
        if(root.val == subroot.val){
            if(isIdentical(root, subroot)) return true;
        }
        //boolean leftans = isSubtree(root.left, subroot);
        //boolean righttans = isSubtree(root.left, subroot);

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
        //return leftans || rightans;
    }
    public static boolean isIdentical(TreeNode root,TreeNode subroot){
        if(root == null && subroot == null){
            return true;
        }
        else if(root == null || subroot == null) return false;

        //left subtree -> non identical
        // if(!isIdentical(root.left, subroot.left)) return false;
        // //right subtree -> non identical
        // if(!isIdentical(root.left, subroot.left)) return false;
        return (root.val == subroot.val) && isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right = new TreeNode(6);
        /*          1
         *         / \
         *        2   3
         *       / \    \
         *      4   5    6
         */
        TreeNode subroot = new TreeNode(2);
        subroot.left = new TreeNode(4);
        //subroot.right = new TreeNode(5);
        /*
         *      2
         *     / \
         *    4   5
         */
        System.out.println(isSubtree(root, subroot));
    }
}
