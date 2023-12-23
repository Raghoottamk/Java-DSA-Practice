public class Q18_Add_1_to_number {


//Following is the class structure of the Node class:

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

        //Approach 2: iterative
        public class Solution {

            public static Node reverse(Node head) {
        
                // If the list is empty or has just one node, return head.
                if (head == null || head.next == null) {
                    return head;
                }
        
                // Pointer to the previous node of the current node.
                Node prev = null;
        
                // Pointer to the current node.
                Node curr = head;
        
                while (curr != null) {
                    
                    // Pointer to the next node of the current node.
                    Node ahead = curr.next;
        
                    // Inverting the links.
                    curr.next = prev;
                    prev = curr;
                    curr = ahead;
                }
        
                return prev;
            }
        
            public  Node addOne1(Node head) {
        
                // Removing leading zeroes.
                while (head != null && head.data == 0) {
                    head = head.next;
                }
        
                // Reverse the list.
                head = reverse(head);
        
                Node temp = head;
        
                // Initialize a variable to store carry.
                int carry = 1;
        
                // Initialize a pointer to store previous node.
                Node prev = head;
        
                // Adding 1 to the reversed linked list.
                while (head != null) {
                    int sum = carry + head.data;
                    carry = sum / 10;
                    sum = sum % 10;
                    head.data = sum;
                    prev = head;
                    head = head.next;
                }
        
                // If there is carry after processing all nodes, add a new node at the end of the linked list.
                if (carry != 0) {
                    Node newNode = new Node(0);
                    newNode.data = carry;
        
                    // Appending the newNode at the end of the resultant list.
                    if (prev != null) {
                        prev.next = newNode;
                    } else {
                        // If the resultant list is empty.
                        return newNode;
                    }
                }
        
                // Reverse the resultant list.
                Node ans = reverse(temp);
        
                return ans;
            }
        }

}




