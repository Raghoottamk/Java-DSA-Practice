import java.util.Scanner;

public class prime_in_range {
    public static boolean isprime(int n) {
        if(n==2){
            return true;
        }
        else if(n>2){
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0){
                    return false;
                }
            }            
        }
        return true;
    }
    public static void primeInRange(int n){
        for(int i =2;i<=n;i++){
            if(isprime(i)){
                System.out.print(i+"\t");
            }
        }System.out.println();
    }
    public static void main(String[] args) {
        primeInRange(10);
    }

}
