public class half_pyramid {
    public static void halfpyramid(int rows){
        //no need of columns as in half pyramid rows = columns
        for(int i=1;i<=rows;i++){
            for(int spaces=1;spaces<=rows-i;spaces++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        halfpyramid(5);
    }
}
