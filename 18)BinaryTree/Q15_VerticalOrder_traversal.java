import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Q15_VerticalOrder_traversal {

    public class TreeNode {
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

    class Solution {
        //detailed explianation in DFS folder Q4
        Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map;
        int min,max;
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            
            if(root == null) return new ArrayList<>();

            map = new HashMap<>();//global declared variable need to be cleared every time for running it successfully
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            dfs(root,0,0);

            List<List<Integer>> res = new ArrayList<>();
            for (int i = min; i <= max; i++) {
                List<Integer> innerList = new ArrayList<>();
                TreeMap<Integer, PriorityQueue<Integer>> treeMap = map.get(i);
                for (int row : treeMap.keySet()) {
                    PriorityQueue<Integer> pq = treeMap.get(row);
                    while (!pq.isEmpty()) {
                        innerList.add(pq.poll());
                    }
                }
                res.add(innerList);
            }
            return res;
        }
        public void dfs(TreeNode root,int row,int col){
            if(root == null) return;

            min = Math.min(min,col);
            max = Math.max(max,col);

            map.computeIfAbsent(col, k -> new TreeMap<>()).computeIfAbsent(row, k -> new PriorityQueue<>()).offer(root.val);
            
            //recursive call
            dfs(root.left , row+1 , col-1);
            dfs(root.right , row+1 , col+1);
        }
    }
    //iterative method
    //we need to store in list according to vertical/col/X so we use Treemap  treemap<X,something>
    //we need to store multiple values for one column based on levels/rows so we use another treemap so treemap<X,Treemap<Y,values>
    //but when the different overlap we need to store them in sorted order so to sort we use PriorityQueue map<X,map<Y,PriorityQueue>
    //when we are doing level order traversal we need to keep track of row and col and root.val so we use class store them
    class Solution2 {
        class Info{
            TreeNode root;
            int row;
            int col;
            public Info(TreeNode root, int row, int col) {
                this.root = root;
                this.row = row;
                this.col = col;
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            TreeMap <Integer, TreeMap <Integer,PriorityQueue <Integer>>> map = new TreeMap < > ();
            Queue <Info> q = new LinkedList<Info>();
            q.offer(new Info(root,0,0));
            while(!q.isEmpty()){
                Info info = q.poll();
                TreeNode curr = info.root;
                int x = info.row;
                int y = info.col;

                if(!map.containsKey(x)){
                    map.put(x,new TreeMap<>());

                }if (!map.get(x).containsKey(y)) {
                    map.get(x).put(y, new PriorityQueue < > ());
                }
                map.get(x).get(y).offer(curr.val);

                if (curr.left != null) {
                    q.offer(new Info(curr.left, x - 1, y + 1));
                }
                if (curr.right != null) {
                    q.offer(new Info(curr.right, x + 1, y + 1));
                }
            }

            List < List < Integer >> list = new ArrayList < > ();
            //for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values())
            for (var ys: map.values()) {
                list.add(new ArrayList < > ());
                //for (PriorityQueue < Integer > nodes: ys.values())
                for (var nodes: ys.values()) {
                    while (!nodes.isEmpty()) {
                        list.get(list.size() - 1).add(nodes.poll());
                    }
                }
            }
            return list;
        }
    }
}
