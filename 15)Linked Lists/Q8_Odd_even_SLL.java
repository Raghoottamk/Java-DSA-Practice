public class Q8_Odd_even_SLL {

//Input: head = [2,1,3,5,6,4,7]
//Output: [2,3,6,7,1,5,4]

//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) { 
            this.val = val; 
        }
        ListNode(int val, ListNode next) {
            this.val = val; 
            this.next = next; 
        }
    }
//Solution
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;
        
        while(even != null && even.next != null){
            odd.next = even.next;//odd -> even -> even.next
            odd = odd.next;

            even.next = odd.next;//now even -> odd -> odd.next
            even = even.next;
        }
        odd.next = evenhead;//last odd -> evenhead

        return head;
    }

}
