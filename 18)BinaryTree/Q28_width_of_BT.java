import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/*
--Question--
Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
It is guaranteed that the answer will in the range of a 32-bit signed integer.

Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

Example 2:
Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

Example 3:
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).

 */
public class Q28_width_of_BT {
    class Solution {
    //striver solution
    //level order traversal
    //solved using 0-based indexing
    class Pair{
        TreeNode first;
        int second;
        Pair(TreeNode first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int min_ind = q.peek().second;//to make every level start from 0 based indexing
            int first = 0,last = 0;
            for(int i = 0; i < size; i++){
                int curr = q.peek().second - min_ind;
                TreeNode node = q.poll().first;

                if(i == 0) first = curr;
                if(i == size - 1) last = curr;

                if(node.left != null) q.offer(new Pair(node.left,2 * curr + 1));
                if(node.right != null) q.offer(new Pair(node.right,2 * curr + 2));
            }
            ans = Math.max(ans,last - first + 1);
        }
        return ans;
    }
}
class Solution2 {
    //using Depth First Search
    //solved using 1-based indexing
    Map<Integer,Integer> map = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        return solve(root,1,0);
    }
    private int solve(TreeNode root,int col,int level){
        if(root == null) return 0;
        
        if(!map.containsKey(level)){
            map.put(level,col);
        }
        int cur = col - map.get(level) + 1;

        int left = solve(root.left,col * 2 - 1,level + 1);
        int right = solve(root.right,col * 2 , level + 1);

        return Math.max(cur,Math.max(left,right));
    }
}
}
