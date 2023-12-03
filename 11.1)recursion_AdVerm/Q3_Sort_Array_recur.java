import java.io.PrintStream;
import java.util.ArrayList;

public class Q3_Sort_Array_recur {
   public Q3_Sort_Array_recur() {
   }

   public static void sort(ArrayList<Integer> list) {
      if (list.size() != 0) {
         int n = list.size();
         int var2 = (Integer)list.get(n - 1);
         list.remove(n - 1);
         sort(list);
         insert(list, var2);
        }
   }

   public static void insert(ArrayList<Integer> list, int var1) {
      int var2 = list.size();
      if (var2 != 0 && (Integer)list.get(var2 - 1) > var1) {
         int var3 = (Integer)list.get(list.size() - 1);
         list.remove(list.size() - 1);
         insert(list, var1);
         list.add(var3);
      } else {
         list.add(var1);
      }
   }

   public static void print(ArrayList<Integer> list) {
      for(int i = 0; i < list.size(); ++i) {
         PrintStream var10000 = System.out;
         int var = list.get(i);
         System.out.print(String.valueOf(var) + "  ");
      }

      System.out.println();
   }

   public static void main(String[] args) {
      ArrayList list = new ArrayList();
      list.add(7);
      list.add(5);
      list.add(6);
      list.add(4);
      list.add(8);
      print(list);
      sort(list);
      print(list);
   }
}
