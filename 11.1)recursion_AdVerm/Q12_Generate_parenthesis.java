import java.util.ArrayList;
import java.util.List;

public class Q12_Generate_parenthesis {

   public static List<String> generateParenthesis(int var0) {
      ArrayList var1 = new ArrayList();
      String var4 = new String();
      solve(var1, var0, var0, var4);
      return var1;
   }

   public static void solve(List<String> var0, int var1, int var2, String var3) {
      if (var1 == 0 && var2 == 0) {
         var0.add(var3);
      } else {
         String var4;
         if (var1 != 0) {
            var4 = var3 + "(";
            solve(var0, var1 - 1, var2, var4);
         }

         if (var2 > var1) {
            var4 = var3 + ")";
            solve(var0, var1, var2 - 1, var4);
         }

      }
   }

   public static void main(String[] args) {
      System.out.println(generateParenthesis(3));
   }
}
