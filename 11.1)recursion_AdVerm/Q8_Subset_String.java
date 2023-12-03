public class Q8_Subset_String {

    public static void printSubsets(String str, String op, int i) {
        if (str.length() == 0) {
            System.out.println(op);
        }  
        else {
            String op1 = op; 
            String op2 = op;
            printSubsets(str, op1 + str.charAt(i), i+ 1);
            printSubsets(str, op2, i + 1);
        }
    }

   public static void main(String[] args) {
      String var1 = "abc";
      String var2 = new String();
      printSubsets(var1, var2, 0);
   }
}
