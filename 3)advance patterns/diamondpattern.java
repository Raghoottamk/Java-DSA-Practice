public class diamondpattern {
    public static void diamond(int n) {
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            //diamond pattern
            for(int k=1;k<=((2*i)-1);k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i2=n;i2>=1;--i2){
            //spaces
            for(int j=1;j<=(n-i2);j++){
                System.out.print(" ");
            }
            //diamond pattern
            for(int k=1;k<=((2*i2)-1);k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        diamond(4);
    }
}

