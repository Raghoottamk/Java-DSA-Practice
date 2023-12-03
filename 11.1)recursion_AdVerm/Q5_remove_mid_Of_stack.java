import java.util.Stack;

public class Q5_remove_mid_Of_stack {

   public static void removeMid(Stack<Integer> var0, int var1) {
      if (!var0.isEmpty()) {
         if (var1 != 1) {
            int var2 = (Integer)var0.pop();
            removeMid(var0, var1 - 1);
            var0.push(var2);
         }
      }
   }

   public static void main(String[] args) {
      Stack var1 = new Stack();
      var1.push(1);
      var1.push(2);
      var1.push(3);
      var1.push(4);
      var1.push(5);
      System.out.println(var1);
      int var2 = var1.size();
      int var3 = var2 / 2 + 1;
      removeMid(var1, 3);
      System.out.println(var1);
   }
}
