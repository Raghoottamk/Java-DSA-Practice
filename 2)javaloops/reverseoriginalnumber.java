//package javaloops;

public class reverseoriginalnumber {
    public static void main(String[] args) {
        int num = 94488;
        int revnum =0;
        while(num>0){
            int lastdigit = num%10;
            revnum = (revnum * 10)+lastdigit;
            num = num/10;
        }
    System.out.printf("the reverse number is %d",revnum);
    }
}
