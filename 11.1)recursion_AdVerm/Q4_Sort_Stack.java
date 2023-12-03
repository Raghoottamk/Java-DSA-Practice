import java.util.Stack;

public class Q4_Sort_Stack {
    public static void sort(Stack<Integer> s) {
        if (s.size() != 1) {
         int n = s.pop();
         sort(s);
         insert(s, n);
        }
    }

    public static void insert(Stack<Integer> s, int n) {
        if (s.size() != 0 && s.peek() > n) {
            int var2 = s.pop();
            insert(s, n);
            s.push(var2);
        } 
        else {
         s.push(n);
        }
    }

   public static void main(String[] args) {
      Stack s = new Stack();
      s.push(8);
      s.push(6);
      s.push(7);
      s.push(4);
      s.push(5);
      System.out.println(s);
      sort(s);
      System.out.println(s);
   }
}
