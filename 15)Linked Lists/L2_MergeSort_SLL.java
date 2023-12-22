public class L2_MergeSort_SLL {
 
 //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
class Solution {
    public ListNode sortList(ListNode head) {
        //base case
        if(head == null || head.next == null) return head;
        //step -1- find mid
        ListNode mid = getMid(head);
        //step -2- sort(left half) and sort(right half)
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        //step -3- merge
        return merge(left,right);
    }
    private ListNode getMid(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode merge(ListNode head1,ListNode head2){
        ListNode helper = new ListNode(-1);
        ListNode temp = helper;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return helper.next;//to avoid extra created -1 Node
    }
    
}
}
