public class Q7_Kth_symbol_in_grammar {
   public Q7_Kth_symbol_in_grammar() {
   }

   public static int kthGrammar(int var0, int var1) {
      if (var0 == 1 && var1 == 1) {
         return 0;
      } else {
         int var2 = (int)Math.pow(2.0, (double)(var0 - 1));
         if (var1 <= var2 / 2) {
            return kthGrammar(var0 - 1, var1);
         } else {
            int var3 = kthGrammar(var0 - 1, var1 - var2 / 2);
            return var3 == 0 ? 1 : 0;
         }
      }
   }

   public static void main(String[] var0) {
      System.out.println(kthGrammar(2, 2));
   }
}
