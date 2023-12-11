import java.util.*;

public class Q6_Josephus_usingQueue {

   public static int findTheWinner(int n, int k) {
      Queue<Integer> q = new LinkedList<>();
      for(int i = 1;i<=n;i++){
         q.add(i);
      }
      while(!(q.size() == 1)){
         int counter = k;
         while(counter > 1){
            int x = q.peek();
            q.remove();
            q.add(x);
            counter--;
         }
         q.remove();
      }
      return q.peek();
   }

   public static void main(String[] args) {
      System.out.println(findTheWinner(5, 2));
   }
}
