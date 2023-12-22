public class Q3_reverseSLL_recursive {

//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { 
            this.val = val; 
        }
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }

    class Solution {
        //recursive approach
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode newhead = reverseList(head.next);
            ListNode front = head.next;
            front.next = head;
            head.next = null;
            return newhead;
        }
    }
}
