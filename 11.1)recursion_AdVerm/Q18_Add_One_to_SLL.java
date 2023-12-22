public class Q18_Add_One_to_SLL {
    class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

    //Approach 1: recursive
    public  Node addNode(Node head) {
        // to remove leading zeroes
        while(head != null && head.data == 0){
            head = head.next;
        }
        int carry = helper(head);
        if (carry == 1) {
            Node newHead = new Node(1);
            //newHead.data = carry;
            newHead.next = head;
            return newHead;
        }
    
        return head;
    }
    public  int helper(Node temp){
        if(temp == null) return 1;
        int carry = helper(temp.next);
        temp.data += carry;
        if(temp.data < 10){
            return 0;
        }
        return 1;
    }
}