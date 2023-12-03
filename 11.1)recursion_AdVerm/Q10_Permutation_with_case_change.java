public class Q10_Permutation_with_case_change {

   public static void permutationCaseChange(String var0, String var1) {
      if (var0.length() == 0) {
         System.out.println(var1);
      } else {
         char var4 = var0.charAt(0);
         char var5 = Character.toUpperCase(var4);
         String var2 = var1 + var4;
         String var3 = var1 + var5;
         var0 = var0.substring(1);
         permutationCaseChange(var0, var2);
         permutationCaseChange(var0, var3);
      }
   }

   public static void main(String[] var0) {
      String var1 = "ab";
      String var2 = new String();
      permutationCaseChange(var1, var2);
   }
}