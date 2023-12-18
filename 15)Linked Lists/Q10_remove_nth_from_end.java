public class Q10_remove_nth_from_end {

//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//brute force
    public ListNode removeNthFromEndBF(ListNode head, int n) {
        int size = 0;
        ListNode temp = new ListNode();
        temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(size == n){
            head = head.next;
            return head;
        }
        if(n > size){
            return head;
        }
        ListNode prev = head;
        int i = 1;
        int iToFind = size - n;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }

//optimal
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null || head.next == null) return null;

        int i = 0;//stay one step behind the node to be deleted then slow.nest = slow.nwxt.next
        while(fast.next != null){
            if(i >= n){
                slow = slow.next;
            }
            fast = fast.next;
            i++;
        }
        if(i+1 == n){
            head = head.next;
            return head;
        }
        slow.next = slow.next.next;

        return head;
    }
}

