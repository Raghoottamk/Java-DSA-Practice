import java.util.Stack;

public class Q2_SLL_Palindrome_check_using_Stack {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; 
        }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> s = new Stack<>();
        while(fast != null && fast.next != null){
            s.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null && fast.next == null){
            //odd case
            slow = slow.next;
        }
        while(!s.isEmpty()){
            if(s.pop() != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
