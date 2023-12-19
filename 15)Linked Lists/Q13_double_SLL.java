import java.util.Stack;

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

            if(!s.isEmpty()){
                temp.val = 2*s.pop();
            }

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
    
    //iterative approach
    public ListNode doubleIt1(ListNode head) {
        if(head == null) return head;
        if (head.val >= 5){
            head = new ListNode(0, head);//creating extra node so that it can be stored if carry exists
        }
        ListNode temp = head;
        while(temp != null) {
            temp.val *= 2;
            temp.val %= 10;
            if (temp.next != null && temp.next.val >= 5) {//temp.next.val >= 5 then gives carry
                temp.val++;
            }
            temp = temp.next;
        }

        return head;
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

