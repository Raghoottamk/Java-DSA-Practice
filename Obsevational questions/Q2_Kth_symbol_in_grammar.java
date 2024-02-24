public class Q2_Kth_symbol_in_grammar {
   //https://leetcode.com/problems/k-th-symbol-in-grammar/description/
   class Solution {
      public static int kthGrammar(int n, int k) {
          //base
          if(n == 1 && k == 1){
              return 0;
          }
          //work
          int length = (int)Math.pow(2,n-1);
          if(k <= length/2){
              return kthGrammar(n-1,k);
          }else{
              int i = kthGrammar(n-1,k-(length/2));
              return i == 0 ? 1 : 0;
          }
      }
  }

   public static void main(String[] args) {
      System.out.println(Solution.kthGrammar(2, 2));
   }
}
