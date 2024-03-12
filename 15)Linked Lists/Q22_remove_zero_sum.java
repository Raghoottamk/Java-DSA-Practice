public class Q22_remove_zero_sum {

//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;  }
}
class Solution {
/*APPROACH :
    check total sum on each node 

    steps-
    if total sum == 0 change the head 
    call recursion i.e to point head.next and val
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return head;
        int tSum = 0;
        ListNode temp = head;
        while(temp != null){
            tSum += temp.val;
            if(tSum == 0){
                head = temp.next;//change the head whenever total sum == 0
            }
            temp = temp.next;
        }
        //call recursive function to point head to next
        //call recursion only when head != null as if head == null total sum != 0 and no need to remove anything
        if(head != null){
            head.next = removeZeroSumSublists(head.next);
        }
        return head;
    }
}
}