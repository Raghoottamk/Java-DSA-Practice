public class Q22_min_distance_btw_twoNodes {

    class Node{
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    } 

/* Should return minimum distance between a and b
   in a tree with given root*/
    class GfG {
        int findDist(Node root, int a, int b) {
            // Your code here
            Node node = LCA(root,a,b);
            int dist1 = LCAdist(node,a);
            int dist2 = LCAdist(node,b);
            
            return dist1+dist2;
        }
        private Node LCA(Node root,int a, int b) {
            if(root == null) return null;

            if(root.data == a || root.data == b) return root;
            //or it above statement can be written as - if(root == p || root == q.) return root;
            Node leftLCA = LCA(root.left,a,b);
            Node rightLCA = LCA(root.right,a,b);

            //situation where one of the val exists and another doesnot{
                if(leftLCA == null){
                    return rightLCA;
                }
                if(rightLCA == null){
                    return leftLCA;
                }
            //}
            
            return root;//if(both exists) i.e if(leftLCA != null && rightLCA != null) return root;
        }
        private int LCAdist(Node root,int n){
            if(root == null) return -1;
            if(root.data == n) return 0;
            
            int left = LCAdist(root.left,n);
            int right = LCAdist(root.right,n);
            //if(both are -1) return -1
            if(left == -1 && right == -1){
                return -1;
            }
            //if(only one of them return -1 then other side has found the node) return thatsideval+1; as we are going to pursue the val
            if(left == -1){
                return right+1;
            }
            if(right == -1){
                return left+1;
            }
            return -1;
        }
    }
}