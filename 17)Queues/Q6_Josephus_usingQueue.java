import java.util.LinkedList;

public class Q6_Josephus_usingQueue {
   public Q6_Josephus_usingQueue() {
   }

   public static int findTheWinner(int var0, int var1) {
      LinkedList var2 = new LinkedList();

      int var3;
      for(var3 = 1; var3 <= var0; ++var3) {
         var2.add(var3);
      }

      while(var2.size() != 1) {
         for(var3 = var1; var3 > 1; --var3) {
            int var4 = (Integer)var2.peek();
            var2.remove();
            var2.add(var4);
         }

         var2.remove();
      }

      return (Integer)var2.peek();
   }

   public static void main(String[] var0) {
      System.out.println(findTheWinner(5, 2));
   }
}
