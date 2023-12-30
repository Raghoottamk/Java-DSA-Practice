import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Q11_Top_view_of_BT {

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
        int hd;
        Info(Node node,int hd){
        this.node = node;
        this.hd = hd;
        }
    }

    class Solution{
        //Function to return a list of nodes visible from the top view 
        //from left to right in Binary Tree.
        
        public static ArrayList<Integer> topView(Node root){
            // using level order traversal
            ArrayList<Integer> list = new ArrayList<>();
            Queue<Info> q = new LinkedList<>();
            Map<Integer,Integer> mp = new TreeMap<Integer,Integer>();
            
            if(root == null) return list;
            
            q.add(new Info(root,0));
            
            // //variables required to traverse later
            // int min = Integer.MAX_VALUE;
            // int max = Integer.MIN_VALUE;
            
            while(!q.isEmpty()){
                Info curr = q.poll();
                
                if(!mp.containsKey(curr.hd)){
                    mp.put(curr.hd,curr.node.data);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.hd - 1));
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right,curr.hd + 1));
                }
            }
            
            for(Map.Entry<Integer,Integer> e:mp.entrySet()){
            list.add(e.getValue());
            }
            return list;
        }
        
    }
    class Solution2{
        //recursive approach
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
        
        static void helper (Node root, int col, int row){
            if (root == null)
                return;
     
            if (map.get(col) == null) {
                map.put(col, new Pair(root.data, row));
            }
            else if (map.get(col).second > row) {
                map.put(col, new Pair(root.data, row));
            }
     
            helper(root.left, col - 1, row + 1);
            helper(root.right, col + 1, row + 1);
        }
        //main function
        static ArrayList<Integer> topView(Node root){
            
            list.clear();
            map.clear();
            
            helper(root, 0, 0);
     
            for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
                System.out.print(entry.getValue().first + " ");
            }
            
            return list;
        }
    }
}
