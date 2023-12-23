public class Q17_Zig_Zag_SLL {

/*Question:
you are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
*/

//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        //Step-1- getmid
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //step-2- reverse second half
        ListNode righthead = slow.next;
        slow.next = null;
        ListNode RH = reverseList(righthead);
        //step-3- zig-zag SLL
        ListNode LH = head;
        ListNode nextL,nextR;
        while(LH != null && RH != null){
            //zig - zag
            nextL = LH.next;
            LH.next = RH;
            nextR = RH.next;
            RH.next = nextL;
            //update
            RH = nextR;
            LH = nextL;
        }
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
