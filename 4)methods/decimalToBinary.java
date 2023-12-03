import java.util.Scanner;

public class decimalToBinary {
    public static void dectobin(long num) {
        long mynum=num;
        long bin=0;
        long power=0;
        while(num>0){
            long rem=num%2;
            bin=bin+(rem*(long)Math.pow(10,power));//Math.pow takes double as arguments and returns the value in double so it is typecasted to long
            power++;
            num/=2;
        }
        System.out.println(mynum+" to decimal is "+bin);
    }
    public static void main(String[] args) {
        System.out.println("enter number");
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        dectobin(n);
    }
}
