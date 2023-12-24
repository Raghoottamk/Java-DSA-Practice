public class L1_Bssics {
    public static class Node {
        public int data;       // Data stored in the node
        public Node next;      // Reference to the next node in the list (forward direction)
        public Node prev;      // Reference to the previous node in the list (backward direction)
    
        // Constructor for a Node with both data, a reference to the next node, and a reference to the previous node
        public Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.prev= back;
        }
    
        // Constructor for a Node with data, and no references to the next and previous nodes (end of the list)
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node insertAtTail(Node list, int K) {
        Node newNode = new Node(K);
    
        // If the doubly linked list is empty, set 'head' to the new node
        if (list == null) {
            return newNode;
        }
    
        // Traverse to the end of the doubly linked list
        Node current = list;
        while (current.next != null) {
            current = current.next;
        }
    
        // Connect the new node to the last node in the list
        current.next = newNode;
        newNode.prev = current;
    
        return list;
    }
    public static Node reverseDLL(Node head)
    {
        // Write your code here.
        if(head == null || head.next == null) return head;
        Node current = head;
        Node prev = null;
        while(current != null){
            prev = current.prev;
            
            // Swap the previous and
            // next pointers
            current.prev = current.next;
            
            // This step reverse the links
            current.next = prev;
            
            // Move to the next node
            current = current.prev;
        }
        return prev.prev;
    }
    
}
