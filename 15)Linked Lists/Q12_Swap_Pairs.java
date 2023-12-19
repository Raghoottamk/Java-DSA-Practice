public class Q12_Swap_Pairs {
    /* 
    Example 1:
    Input: head = [1,2,3,4]
    Output: [2,1,4,3]

    Example 2:
    Input: head = []
    Output: []

    Example 3:
    Input: head = [1]
    Output: [1]

    Example 4:
    Input: [1,2,3,4,5]
    Output: [2,1,4,3,5]
    */
//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next.next;
        ListNode endhead = head.next;
        head.next.next = head;
        head.next = swapPairs(temp);
        return endhead;
    }  
}
