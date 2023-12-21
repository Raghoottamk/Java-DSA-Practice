import java.util.Stack;

public class Q3_deleteNode_LL_if_next_greater {
    /*Question- 
You are given the head of a linked list.
Remove every node which has a node with a greater value anywhere to the right side of it.
Return the head of the modified linked list
*/
/*
Example 1:
    Input: head = [5,2,13,3,8]
    Output: [13,8]
    Explanation: The nodes that should be removed are 5, 2 and 3.
    - Node 13 is to the right of node 5.
    - Node 13 is to the right of node 2.
    - Node 8 is to the right of node 3.
Example 2:
    Input: head = [1,1,1,1]
    Output: [1,1,1,1]
    Explanation: Every node has value 1, so no nodes are removed.
*/
//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //Little optimized using Stack
    public ListNode removeNodes1(ListNode head) {
        if(head == null || head.next == null) return head;
        //Approach
        //step-1- reverse LL.
        //step-2- store the elements of LL if its greater than previous.
        //step-3- store all the stack values in LL
        Stack<Integer> s = new Stack();

        ListNode temp = reverseList(head);

        // s.push(temp.val);
        // temp = temp.next;
        while(temp != null){
            if(s.isEmpty() || s.peek() <= temp.val){
                s.push(temp.val);
            }
            temp = temp.next;
        }
        
        temp = head;
        while(!s.isEmpty()){
            temp.next = new ListNode(s.pop());
            temp = temp.next;
        }
        if(s.isEmpty() && temp != null){
            temp = null;
        }
        return head.next;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
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
