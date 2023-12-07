import java.util.HashMap;
public class MoreSubsequence {
    public static int func(String s, int n) {
        // Initializing 'count' with 1.
        int count = 1;

        // Creating a HashMap of [char, int] 'm1'.
        HashMap<Character, Integer> m1 = new HashMap<>();

        // Calculating number of distinct subsequences.
        for (int i = 0; i < n; i++) {
            if (!m1.containsKey(s.charAt(i))) {
                m1.put(s.charAt(i), count);
                count *= 2;
            } else {
                int temp = m1.get(s.charAt(i));
                m1.put(s.charAt(i), count);
                count *= 2;
                count -= temp;
            }
        }
        return count;
    }

    public static String moreSubsequence(int n, int m, String a, String b) {
        if (func(a, n) >= func(b, m)) {
            return a;
        } else {
            return b;
        }
    }
    public static void main(String[] args){
      String a = "ab";
      String b = "dd";
      System.out.println(moreSubsequence(a.length(), b.length(), a, b));
    }
}
   
