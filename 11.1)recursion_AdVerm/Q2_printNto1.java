public class Q2_printNto1 {
   public static void printNto1(int n) {
      if (n == 1) {
         System.out.println(1);
      } else {
         System.out.println(n);
         printNto1(n - 1);
      }
   }

   public static void main(String[] args) {
      printNto1(10);
   }
}