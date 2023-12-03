import java.util.Scanner;

public class primecheck {
    public static void main(String[] args) {
        System.out.println("enter the number for prime check");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isprime = true;
        int times=0;//is optional as it just checks the number of times the loop ran
        if(n==2){
            System.out.println(n+" is prime number");
        }
        else if(n>2){
            for(int i=2;i<=Math.sqrt(n);i++){
             //for(int i=2;i<=Math.sqrt(n) is optimised as checking till square root of n is enough for prime check
             //for(int i=2;i<=n-1;i++) is not optimized as it checks till the n-1
                if(n%i==0){
                    isprime = false;
                    //break;
                }times++;//is optional as it just checks the number of times the loop ran
            }
            if(isprime == true){
                System.out.println(n+" is prime number");
                System.out.println("the no. of times the loop ran is"+times);
                System.out.printf("the integer root of the number is %d",times+1);//times+1 as we start prime check with the i==2 but not i==1
            }
            else{
                System.out.println(n+" is not prime number");
                System.out.println("the no. of times the loop ran is"+times);
                System.out.printf("the integer root of the number is %d",times+1);
            }

        }else{
            System.out.println("cant say anything");
        }
        

    }
    
}
