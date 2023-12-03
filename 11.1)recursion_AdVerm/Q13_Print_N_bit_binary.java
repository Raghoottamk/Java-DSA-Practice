public class Q13_Print_N_bit_binary {
   public Q13_Print_N_bit_binary() {
   }

   public static void solve(int var0, int var1, int var2, String var3) {
      if (var0 == 0) {
         System.out.println(var3);
      } else {
         String var4 = var3 + "1";
         solve(var0 - 1, var1 + 1, var2, var4);
         if (var1 > var2) {
            String var5 = var3 + "0";
            solve(var0 - 1, var1, var2 + 1, var5);
         }

      }
   }

   public static void main(String[] args) {
      String var1 = new String();
      solve(3, 0, 0, var1);
   }
}
