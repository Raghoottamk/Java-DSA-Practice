public class literals{
    public static void main(String args[]){
        byte age = 34; //till -(2^16)/2 to (2^16)/2-1 i.e. 2 bytes
        int age2 = 300; //till -(2^32)/2 to (2^32)/2-1 i.e. 4 bytes
        long age3 = 300000; //till -2^64 to 2^64/2 -1 i.e. 8 bytes
        float number =35.6f;//4 bytes
        char num1 ='a';//2bytes
        double num2=48.8d;//8bytes
        boolean numis= true;//default os false and size depends on JVM
        System.out.println(age);
        System.out.println(age2);
        System.out.println(age3);
        System.out.println(number);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(numis);
        
    }
}