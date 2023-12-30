package Hash_TreeMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Q1_Topview_BT {
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
}
