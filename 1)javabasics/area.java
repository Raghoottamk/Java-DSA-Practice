import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float radius = sc.nextFloat();
        float area = 3.14f *radius*radius;//3.14 throws area becoz by default 3.14=3.13d i.e.double
        System.out.println(area);

    }
}
