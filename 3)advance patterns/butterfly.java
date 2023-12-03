public class butterfly {
    public static void butterfly(int n){
        //1st half
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int space=1;space<=2*(n-i);space++){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        //2nd half
        for(int i2=n;i2>=1;i2--){
            for(int j=1;j<=i2;j++){
                System.out.print("*");
            }
            for(int space=1;space<=2*(n-i2);space++){
                System.out.print(" ");
            }
            for(int k=1;k<=i2;k++){
                System.out.print("*");
            } 
            System.out.println();
        }
    }
    public static void main(String[] args) {
        butterfly(6);
    }
}
