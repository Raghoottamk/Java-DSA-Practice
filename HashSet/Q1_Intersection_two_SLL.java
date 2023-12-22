package HashSet;

import java.util.HashSet;

public class Q1_Intersection_two_SLL {

//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> st=new HashSet<>();
        while(headA != null) {
            st.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(st.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}
