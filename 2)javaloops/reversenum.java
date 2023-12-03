//package javaloops;

public class reversenum {
    public static void main(String[] args) {
        for(int num = 944886264;num>0;num=num/10){
            int lastdigit = num%10;
            System.out.print(lastdigit);
            /*
            int n = 9448862643
            while(n>0){
                int lastdigit = n%10;
                System.out.print(lastdigit);
                n = n%10;
            }
            */
        }
        
    }
}
