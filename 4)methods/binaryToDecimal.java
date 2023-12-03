import java.util.Scanner;

public class binaryToDecimal {
    public static void bintodec(long binnum) {
        long mynum=binnum;
        long dec=0;
        long power=0;
        while(binnum>0){
            long LD=binnum%10;
            dec=dec+(LD*(long)Math.pow(2,power));//Math.pow takes double as arguments and returns the value in double so it is typecasted to long
            power++;
            binnum=binnum/10;
        }
        System.out.println(mynum+"to decimal is"+dec);
    }
    public static void main(String[] args) {
        System.out.println("enter a binary number");
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        bintodec(n);
    }
}
