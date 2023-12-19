public class Q13_double_SLL {

//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //recursive approach
    public int getCarry(ListNode head){
        if(head.next == null){
            head.val *=2;
            int carry = head.val/10;
            head.val %= 10;
            return carry;
        }
        int carry = getCarry(head.next);
        head.val *=2;
        head.val += carry;
        carry = head.val/10;
        head.val %= 10;
        return carry;
    }
    public ListNode doubleIt(ListNode head) {
        if(head == null) return head;
        int carry = getCarry(head);
        if(carry == 0) return head;
        //if(carry != 0)
        head = new ListNode(carry, head);
        return head;
    }
}

