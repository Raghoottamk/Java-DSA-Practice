import java.util.Stack;

public class Q6_reverse_Stack {

   public static void reverseStack(Stack<Integer> var0) {
      if (!var0.isEmpty()) {
         int var1 = (Integer)var0.pop();
         reverseStack(var0);
         pushDown(var0, var1);
      }
   }

   public static void pushDown(Stack<Integer> var0, int var1) {
      if (var0.isEmpty()) {
         var0.push(var1);
      } else {
         int var2 = (Integer)var0.pop();
         pushDown(var0, var1);
         var0.push(var2);
      }
   }

   public static void main(String[] var0) {
      Stack var1 = new Stack();
      var1.push(1);
      var1.push(2);
      var1.push(3);
      var1.push(4);
      System.out.println(var1);
      reverseStack(var1);
      System.out.println(var1);
   }
}
