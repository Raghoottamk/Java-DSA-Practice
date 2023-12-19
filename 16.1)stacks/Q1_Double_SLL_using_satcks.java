import java.util.*;
public class Q1_Double_SLL_using_satcks {
    public class Q13_double_SLL {

    //Definition for singly-linked list.
        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        //brute force : using stack
        public ListNode doubleIt3(ListNode head) {
            Stack<Integer> s = new Stack<>();
            ListNode temp = head;
            while(temp != null){
                s.push(temp.val);
                temp = temp.next;
            }
        
            if(head.val >= 5){
                head = new ListNode(0,head);
            }
        
            temp = head;
            ListNode t = temp;
            int carry = 0;
        
            while(!s.isEmpty()){
                temp.val = 2*s.pop();
                temp.val += carry;
                carry = temp.val/10;
                temp.val %= 10;
                temp = temp.next;
            }
            if(carry != 0){
                temp.val = carry;
                temp = temp.next;
            }
            return reverseList(head);
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
}