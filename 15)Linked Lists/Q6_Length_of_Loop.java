import java.util.*;
public class Q6_Length_of_Loop {
    //given Node
    class Node {
        public int data;
        public Node next;

        Node(){
            this.data = 0;
            this.next = null;
        }

        Node(int data){
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    //brute force approach
    public  int lengthOfLoop(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int timer = 1;
        while(temp != null){
            if(map.containsKey(temp)){
                int val = map.get(temp);
                return timer - val;
            }
            map.put(temp,timer);
            timer++;
            temp = temp.next;
        }
        return 0;
    }
    //optimal appraoch
    public static int lengthOfLoop2(Node head) {
        // Write your code here
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null) return 0;
        //slow stays constant
        fast = fast.next;
        int cnt = 1;
        while(fast != slow){
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }
}