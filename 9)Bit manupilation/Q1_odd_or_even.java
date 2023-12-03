import java.util.Scanner;

public class Q1_odd_or_even {
    public static void odd_even(int n) {
        
        int bitmask = 1;
        if((n & 1) == 1){
            System.out.println(n + " odd");
        }
        else{
            System.out.println(n + " even");
        }
    }
    public static int getIthbit(int n,int i){
        int bitmask = 1<<i;
        if((n & bitmask) ==0 ){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static int setIthbit(int n,int i){
        int bitmask = 1<<i;
        return n | bitmask;
    }
    public static int clearIthbit(int n,int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }
    public static int updateIthBit(int n,int i,int newBit){
        //method 1
        // if(newBit == 0){
        //     return clearIthbit(n,i);
        // }
        // else{
        //     return setIthbit(n,i);
        // }
        //method 2
        n = clearIthbit(n,i);
        int bitmask = newBit << i;
        return n|bitmask;
    } 
    public static void main(String[] args) {
        //System.out.println("odd_even");
        //odd_even();
        // System.out.println("getithbit");
        // System.out.println(getIthbit(10,1));
        // System.out.println("setIthbit");
        // System.out.println(setIthbit(10,2));
        // System.out.println("clearIthbit");
        // System.out.println(clearIthbit(10, 3));
        System.out.println("updateIthBit");
        System.out.println(updateIthBit(10,2,1));
    }    
}
