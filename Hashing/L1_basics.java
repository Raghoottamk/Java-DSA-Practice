import java.util.*;
public class L1_basics {
    public static void main(String[] args) {
        // int n = 5;
        // int[] arr = new int[n];
        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter the elements in array");
        // for(int i = 0;i < n;i++){
        //     arr[i] = sc.nextInt();
        // }

        // //Precompute
        // int[] hash = new int[15];
        // for(int i = 0;i < n;i++){
        //     hash[arr[i]] += 1;
        // }
        // //display hash
        // for(int i = 0;i < hash.length;i++){
        //     System.out.print(hash[i] + "  ");
        // }

        // //querry
        // int q;
        // System.out.println("enter the querry");
        // q = sc.nextInt();
        // while(q > 0){
        //     int number;
        //     System.out.println("enter the number");
        //     number = sc.nextInt();
        //     //fetch 
        //     System.out.println(hash[number]);
        //     q--;
        // }
        String s = new String();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string");
        s = sc.nextLine();
        //precompute
        int[] hash = new int[26];
        for(int i =0;i<s.length();i++){
            hash[s.charAt(i) - 'a']++;
        }
        //querry
        int q;
        System.out.println("enter querry");
        q = sc.nextInt();
        while(q > 0){
            char c;
            System.out.println("enter a char");
            c = sc.next().charAt(0);
            System.out.print( hash[c -'a' ]+ "  ");
            q--;
        }
    }
}
