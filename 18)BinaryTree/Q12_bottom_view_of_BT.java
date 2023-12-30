import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Q12_bottom_view_of_BT {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    class Info{
        Node node;
        int col;
        Info(Node node,int col){
            this.node = node;
            this.col = col;
        }
    }
    class Solution{
        //Function to return a list containing the bottom view of the given tree.
        public ArrayList <Integer> bottomView(Node root){
            // Code here
            ArrayList<Integer> list = new ArrayList<>();
            Queue<Info> q = new LinkedList<Info>();
            Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
            
            q.offer(new Info(root,0));
            
            while(!q.isEmpty()){
                var curr = q.poll(); 
                
                map.put(curr.col,curr.node.data);
                
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.col - 1));
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right,curr.col + 1));
                }
            }
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getValue());
            }
            return list;
        }
    }
    //recursive approach
    class Solution2{
        static class Pair{
            int first;
            int second;
            
            Pair(int first, int second){
                this.first = first;
                this.second = second;
            }
        }
        static ArrayList<Integer> list = new ArrayList<>();
        static Map<Integer,Pair> map = new TreeMap<Integer,Pair>();
        
        //d stands for col i.e. distance on x - axis
        //l stands for row i.e. levels/height
        static void helper (Node root, int d, int l){
            if (root == null)
                return;
     
            if (map.get(d) == null || map.get(d).second <= l) {//equal to needs to be checked because overlapping condition we need to assign rightside available rather than left side available
                map.put(d, new Pair(root.data, l));
            }
            
     
            helper(root.left, d - 1, l + 1);
            helper(root.right, d + 1, l + 1);
        }
        
        public ArrayList <Integer> bottomView(Node root){
            list.clear();
            map.clear();
            helper(root, 0, 0);
     
            for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
                list.add(entry.getValue().first);
            }
            
            return list;
        }
    }
}
