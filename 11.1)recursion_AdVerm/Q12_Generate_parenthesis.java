import java.util.ArrayList;
import java.util.List;

public class Q12_Generate_parenthesis {

   public static List<String> generateParenthesis(int n) {
      List<String> list = new ArrayList<String>(); 
      int open = n;
      int close = n;
      String op = new String();
      solve(list,open,close,op);
      return list;
   }
   public static void solve(List<String> list,int open,int close,String op){
         //base case
         if(open == 0 && close == 0){
            list.add(op);
            return;
         }

         //work
         //first choice closing
         if(open != 0){//means closing is used more than opening
            String op1 = op;
            op1 = op1 + '(';
            solve(list,open - 1,close,op1);
         }
         if(close > open){//no. of open i.e. '(' is used more than close
            String op2 = op;
            op2 = op2 + ')';
            solve(list,open,close - 1,op2);
         }
         return;
   }

   public static void main(String[] args) {
      System.out.println(generateParenthesis(3));
   }
}
