public class Q1print1toN {
    public static void print1toN(int n) {
        if (n == 1) {
          System.out.println(1);
        } 
        else {
              print1toN(n - 1);
              System.out.println(n);
        }
    }
     
    public static void main(String[] var0) {
       print1toN(3);
    } 
        
}

