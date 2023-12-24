public class Q1_copy_arr_to_DLL {

//Following is the class structure of the Node class:

    public static class Node {
        public int data;
        public Node next;
        public Node prev;

        Node()
        {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(int data, Node next, Node prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public static Node constructDLL(int []arr) {
        // Write your code here
        Node head = new Node(arr[0]);
        Node tail = head;
        for(int i = 1; i < arr.length; i++){
            Node curr = new Node(arr[i]);
            tail.next = curr;
            curr.prev = tail;
            tail = curr;
        }
            return head;
    }
}
