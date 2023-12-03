import java.util.*;

public class Q10_letter_case_permutation {
   public Q10_letter_case_permutation() {
   }

   public static ArrayList<String> letterCase(String var0, String var1, ArrayList<String> var2) {
      if (var0.length() == 0) {
         var2.add(var1);
         System.out.println(var1);
         return var2;
      } else {
         char var3 = var0.charAt(0);
         if (Character.isAlphabetic(var3)) {
            char var4 = Character.toLowerCase(var3);
            char var5 = Character.toUpperCase(var3);
            String var6 = var1 + var4;
            String var7 = var1 + var5;
            var0 = var0.substring(1);
            letterCase(var0, var6, var2);
            letterCase(var0, var7, var2);
         } else {
            String var8 = var1 + var0.charAt(0);
            var0 = var0.substring(1);
            letterCase(var0, var8, var2);
         }

         return var2;
      }
   }

   public static void main(String[] var0) {
      String var1 = "a1B2";
      String var2 = new String();
      ArrayList var3 = new ArrayList();
      letterCase(var1, var2, var3);
      System.out.println(var3);
   }
}
