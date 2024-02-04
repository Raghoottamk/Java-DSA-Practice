import java.util.LinkedList;
import java.util.Queue;

public class Q34_check_if_BT_is_complete_or_not {
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < q.size(); ++i){
                TreeNode curr = q.poll();
                if(curr == null && !q.isEmpty()){
                    //check if all the things are null
                    while(!q.isEmpty()){
                        if(q.poll() != null) return false;
                    }
                    return true;
                }
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return true;
    }
}
}
