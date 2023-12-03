public class hollow_rectangle {
    public static void HollowRectangle(int rows,int columns){
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                if(i==1||j==1||i==rows||j==columns){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HollowRectangle(4,5);
    }
}
