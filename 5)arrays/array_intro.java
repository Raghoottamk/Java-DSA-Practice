import java.util.Scanner;

public class array_intro {
    public static void main(String[] args) {
        //normal declaring of string 
        float marks[]=new float[50];//declaring the size if the array just as in c language
        float numbers[] = {(float)1.2,11,12,13};//in java 1.2 is basically stored as double not float
        //array  of the strings
        String fruits[]={"apple","mango","banana"}; 
        //input
        Scanner sc = new Scanner(System.in);
        marks[0]=sc.nextFloat();
        marks[1]=sc.nextFloat();
        marks[2]=sc.nextFloat();
        //output
        System.out.println("subject1: "+marks[0] + "~subject2: "+marks[1] +"subject3: "+marks[2]);
        //update
        marks[0]=100;
        System.out.println("subject1="+marks[0]);
        //length of array 
        int length = marks.length;
        System.out.println("length is"+length);
        int length2 = fruits.length;
        System.out.println("length2 is"+length2);
        System.out.println("length is"+marks.length);
    }
}
