import java.util.HashSet;

public class Q16_Intersection_SLL {

//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Approach -1- using Hashset
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

    //Approach -2- normal loops
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        
        int cnt1 = 0,cnt2 = 0;
        for(ListNode temp = headA;temp != null ; temp = temp.next){
            cnt1++;
        }
        for(ListNode temp = headB;temp != null ; temp = temp.next){
            cnt2++;
        }
        ListNode t1 = headA;
        ListNode t2 = headB;
        if(cnt1 > cnt2){
            while(cnt1 != cnt2){
                t1 = t1.next;
                cnt1--;
            }
        }
        else{
            while(cnt2 != cnt1){
                t2 = t2.next;
                cnt2--;
            }
        }
        while(t1 != null && t2!=null){
            if(t1 == t2){
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }
    //optimal approach
    public ListNode getIntersectionNode2(ListNode head1, ListNode head2) {
        ListNode d1 = head1;
        ListNode d2 = head2;
        
        while(d1 != d2) {
            d1 = d1 == null? head2:d1.next;
            d2 = d2 == null? head1:d2.next;
        }
        
        return d1;
    }
}

