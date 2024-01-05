public class Q9_Permutation_Spaces {

   public static void permutationSpaces(String str1, String str2) {
      if (str1.length() == 0) {
         System.out.println(str2);
      } else {
         String op1 = str2 + " " + str1.charAt(0);
         String op2 = str2 + str1.charAt(0);
         str1 = str1.substring(1);
         permutationSpaces(str1, op1);
         permutationSpaces(str1, op2);
      }
   }

   public static void main(String[] args) {
      String str1 = "ABC";
      String str2 = "";
      char ch = str1.charAt(0);
      str1 = str1.substring(1);
      permutationSpaces(str1, str2 + ch);
   }
}
