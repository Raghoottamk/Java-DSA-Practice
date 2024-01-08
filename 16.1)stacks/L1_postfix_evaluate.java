import java.util.Stack;

public class L1_postfix_evaluate {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> st = new Stack<>();
            for(String ch : tokens){
                if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")){
                    int x = st.pop();
                    int y = st.pop();

                    switch(ch){
                        case "+":
                            //st.push(Integer.toString(123));
                            st.push(x + y);
                            break;

                        case "-":
                            st.push(y - x);
                            break;

                        case "*":
                            st.push(x * y);
                            break;

                        case "/":
                            st.push(y / x);
                            break;
                    }
                }
                else{
                    st.push(Integer.parseInt(ch));
                }
            }
            
            return st.pop();
        }
    }
}