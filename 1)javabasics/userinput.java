import java.util.Scanner;
public class userinput {
    public static void main(String[] args) {
        System.out.println("enter the user input for .next()");

        
        Scanner sc = new Scanner(System.in);
        String input = sc.next();//prints only raghu if the input was "raghu uk"
        System.out.println(input);

        System.out.println("enter the user input for .nextLine()");
        //Scanner sc1 = new Scanner(System.in);
        String input2 = sc.nextLine();//prints complete raghu uk if the input was "raghu uk"
        System.out.println(input2);
        
        System.out.println("enter number 1:");
        //Scanner sc2 = new Scanner(System.in);
        boolean b1 = sc.hasNextInt();//prints true if the input is int in 
                                     //print function where b1 is called
        int a = sc.nextInt();
        System.out.println(b1);      //here the b1 is printed

        System.out.println("enter the number 2:");
        boolean b2 = sc.hasNextInt();//prints true if the input is int
        int b = sc.nextInt();
        System.out.println(b2);      //here the b2 is called in printf

        int sum = a + b;
        System.out.print("the sum is:");
        System.out.println(sum);

    }
    
}
