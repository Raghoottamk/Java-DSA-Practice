import java.util.Stack;

public class Q7_check_palindrome {
//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; 
        }
    }
    //brute force
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.val != stack.peek()) return false;
            temp = temp.next;
            stack.pop();
        }
        return true;
    }
    //optimal
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverseList(slow.next);
        slow = slow.next;
        ListNode dummy = head;
        
        while(slow!=null) {
            if(dummy.val != slow.val) return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = new ListNode();
        ListNode curr = new ListNode();
        ListNode prev = new ListNode();
        curr = head;
        prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
