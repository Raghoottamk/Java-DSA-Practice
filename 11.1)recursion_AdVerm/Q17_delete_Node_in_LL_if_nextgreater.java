public class Q17_delete_Node_in_LL_if_nextgreater {
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
    //optimal recursive approach
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newNode = removeNodes(head.next);
        //newNode represents next of head
        //so comparision can be done between head and newNode
        if(newNode.val > head.val){
            return newNode;
        }
        //when head.val > newNode.val, we need to add ans in output
        head.next = newNode;
        return head;
    }
}
