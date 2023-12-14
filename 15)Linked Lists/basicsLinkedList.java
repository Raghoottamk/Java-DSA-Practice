import java.util.LinkedList;

public class basicsLinkedList{
    //1- creating a linkedlist
    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //as we know there are only one head and one tail in LL so we can create it as a property of the linked list class
    public static Node head;
    public static Node tail;
    //2)add in LinkedList
    //2.1)add first in Linkedlist: this means head of the linked will be changed 
    /*approach:
     step-1- create new node
     step-2- new node's next = head
     step-3- head = new Node
     */
    public static int size;
    //static keyword need not to be used as main function calls the other function and static functions can only call static function. But here we call the addFirst() and addLast() thorugh the objects of the linkedList, so it does not matter if the methods are static or not
    public void addFirst(int data){
        //step-1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){//when linkedlist is empty
            head = tail = newNode;
            return;
        }

        //step2- newNode next = head
        newNode.next = head;//linking the previous head in the linkedlist to the newNode which becomes the new head after adding first in step 3
        //even if the head value change in the step 3 but newNode.next holds the value of the refrence of head in step 2

        //step3- head = newNode
        head = newNode;
    }
    //2.2)add last in LinkedList:
      /*approach:
       step-1 -> create new node
       step-2 -> tail next = newNode
       step-3 -> tail = newNode
       */
    public void addLast(int data){
        //step-1 -> create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step-2 -> tail next = newNode
        tail.next = newNode;
        //step-3 -> tail = newNode
        tail = newNode;
    }
    //3-Printing the LinkedList
    public void print(){
        //if linkedlist is empty
        if(head == null){
            System.out.println("linkedlist is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    //4-Adding newNode in the middle of the linked list
    public void addMid(int idx,int data){
        if(idx == 0){
            addFirst(data);
            size++;
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1){
            temp = temp.next;
            i++;         
        }
        //i = idx-1; when temp is at prev of ith node
        newNode.next = temp.next;//newNode i.e. the inserting node will point to ith node as it was pointed at i-1's next
        temp.next = newNode;//node at i-1(i.e. temp.next) will point to new inserting node
    }
    //5-remove in a linked list
    //5.1-remove first
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return -1;
        }else if(size == 1){
            //head = tail
            int val =head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    //5.2-remove last
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            //head = tail
            int val =head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //Last : i = size-1
        //prev : i = size-2 
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;//val which is removed
        //or int val = tail.data
        prev.next = null;
        tail = prev;
        return val;
    }

    /*5.3- delete any element by taking index of the element to be deleted
     Note- study Search on Linked List before studying the removeAny()
    */
    public int removeAny(int idx){
        //calculate size
        int sz = 1;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        //corner cases
        if(idx == 0){
            return removeFirst();
        }
        else if(idx == sz-1){
            return removeLast();
        }
        else{
            Node prev = head;
            int i =0; 
            while(prev !=null && i<idx-1){
                prev = prev.next;
                i++;
            }
            int val = prev.next.data;
            prev.next = prev.next.next;
            return val;
        }
        //dummy return
        //return Integer.MIN_VALUE;    //linked list is not of provided length
    }
    //6-Search in linkedlist
    //6.1-Iterative search in Linked List
    //search for key in linked list. return the position where it is found. If not return -1.
    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    //6.2 iteration using recursion
    public int helper(Node head,int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;//backtracting step
    }
    public int recSearch(int key){
        return helper(head,key);
    }

    //7
    //Q-1- reverse a liked list
    public void reverse(){
        /*approach 
        if LL = 1->2->3->4->5->null 
        rev LL = null<-1<-2<-3<-4<-5
        */
        Node prev = null;
        Node curr = tail = head;//as we are reversing tail should become head 
        Node next;//will be initialised while iterating

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;//as curr becomes null
    }

    //8
    //Q-2-Find and remove Nth node from end
    //this question is basically delete from middle
    public void deleteNthfromEnd(int n) {
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        System.out.println(sz);
        if(n == sz) {
            head = head.next;//removeFirst
            return;
        }
        //we need to remove (size-n+1)
        int i =1;
        int iToFind = sz-n;
        /*or
        int i = 0;
        int iToFind = sz-n+1;
        */
        Node prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // 9
    // Check if LL is a Palindrome
    /*Approach-
      step-1-find midNode
      step-2-reverse the second half
      step-3-check if 1st half == 2nd half
     */
    //find mid through slow-fast(also known as turtle-hare approach)
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;//+1 step
            fast = fast.next.next;//+2 step
        }
        return slow;
    }
    public boolean checkPalindrome() {
        if(head == null || head.next == null){
            return true;
        }
        //step-1-find midNode
        Node midNode = findMid(head);
        //step-2-reverse the second half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;//right half head
        Node left = head;
        //step-3-check if 1st half == 2nd half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        /*syntax
          LinkedList ll = new LinkedList();*/ 
        basicsLinkedList ll = new basicsLinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addMid(2, 3);
        // ll.print();
        // System.out.println("size of ll is"+size);

        // ll.removeFirst();
        // ll.print();

        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.removeAny(0));
        // ll.print();
        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(10));
        // System.out.println(recSearch(3));
        // System.out.println(recSearch(10));
        // ll.print();
        // ll.reverse();
        // ll.print();
        // ll.deleteNthfromEnd(3);
        // ll.print();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        //ll.print();
        //System.out.println(ll.checkPalindrome());
        ll.deleteNthfromEnd(2);
        ll.print();
    }
}