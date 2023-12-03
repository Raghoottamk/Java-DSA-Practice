import java.util.Scanner;

public class percentage {
    public static void main(String[] args) {
        //taking maximumum marks in subject as input
        System.out.println("enter the maaximum marks in one subject:");
        System.out.println("enter the maxmark :");
        Scanner smax = new Scanner(System.in);
        boolean bool = smax.hasNextFloat();
        float maxsubmarks = smax.nextFloat(); 
        System.out.println(bool); 

        System.out.println("enter the marks of student:");
        //subject 1
        System.out.println("enter the marks in subject 1:");
        Scanner s1 = new Scanner(System.in);
        boolean b1 = s1.hasNextFloat();
        float sub1 = s1.nextFloat();
        System.out.println(b1);;

        //subject 2
        System.out.println("enter the marks in subject 2:");
        Scanner s2 = new Scanner(System.in);
        boolean b2 = s2.hasNextFloat();
        float sub2 = s2.nextFloat();
        System.out.println(b2);

        //subject 3
        System.out.println("enter the marks in subject 3:");
        Scanner s3 = new Scanner(System.in);
        boolean b3 = s3.hasNextFloat();
        float sub3 = s3.nextFloat();
        System.out.println(b3);

        float percent = (sub1+sub2+sub3)*100/(3*maxsubmarks);
        System.out.print("percentage is:");
        System.out.println(percent);
    }
}
