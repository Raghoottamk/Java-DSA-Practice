public class call_by_value {
    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a inside the scope of function is:"+a);
        System.out.println("b inside the scope of function is:"+b);
    }
    public static void main(String[] args) {
    int a = 10;
    int b = 5;
    swap(a, b);
    System.out.println("a inside the scope of main is:"+a);
    System.out.println("b inside the scope of main is:"+b);

}

}
