import java.util.HashSet;
import java.util.Set;

public class Q4_detect_loop_SLL {
    
//Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //floyd's cycle finding algo
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){//cycle exists
                return true;
            }
        }
        return false;
    }
    
    //detecting loop using set
    public boolean hasCycle2(ListNode head) {
        ListNode ptr = head;
        Set<ListNode> cycle = new HashSet();
        while(ptr != null){
            if(cycle.contains(ptr)){
                return true;
            }
            cycle.add(ptr);
            ptr = ptr.next;
        }
        return false;
    }
}
