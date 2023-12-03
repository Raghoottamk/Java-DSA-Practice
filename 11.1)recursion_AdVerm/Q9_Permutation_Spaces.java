public class Q9_Permutation_Spaces {

   public static void permutationSpaces(String var0, String var1) {
      if (var0.length() == 0) {
         System.out.println(var1);
      } else {
         String var2 = var1 + " " + var0.charAt(0);
         String var3 = var1 + var0.charAt(0);
         var0 = var0.substring(1);
         permutationSpaces(var0, var2);
         permutationSpaces(var0, var3);
      }
   }

   public static void main(String[] var0) {
      String var1 = "ABC";
      String var2 = "";
      char var3 = var1.charAt(0);
      var1 = var1.substring(1);
      permutationSpaces(var1, var2 + var3);
   }
}
