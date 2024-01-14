import java.util.LinkedList;
import java.util.Queue;

public class Q23_find_kth_ancestor {

    class Node {
        int data;
        Node left, right;
        
        public Node(int data){
            this.data = data;
        }
    }


    class Solution
    {
        public int kthAncestor(Node root, int k, int targetval){
            //Write your code here
            int ancestors[] = new int[100001];//Acc to constraints 10^5 was the last value of the no. of nodes and value of nodes
    
            // generate first ancestor array  
            generateArray(root,ancestors);  
        
            // variable to track record of number of  
            // ancestors visited  
            int count = 0;  
        
            while (targetval!=-1)  
            {  
                targetval = ancestors[targetval];  
                count++;  
        
                if(count==k)  
                    break;  
            }  
        
            // print Kth ancestor  
            return targetval;  
        }
        private void generateArray(Node root, int ancestors[])  {  
            // There will be no ancestor of root targetval  
            ancestors[root.data] = -1;  
        
            // level order traversal to  
            // generate 1st ancestor  
            Queue<Node> q = new LinkedList<Node> ();  
            q.add(root);  
        
            while(!q.isEmpty())  
            {  
                Node temp = q.peek();  
                q.remove();  
        
                if (temp.left != null)  
                {  
                    ancestors[temp.left.data] = temp.data;  
                    q.add(temp.left);  
                }  
        
                if (temp.right != null)  
                {  
                    ancestors[temp.right.data] = temp.data;  
                    q.add(temp.right);  
                }  
            }  
        }  
        
    }
}