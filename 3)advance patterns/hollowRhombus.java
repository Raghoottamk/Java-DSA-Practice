public class hollowRhombus {
    public static void main(String[] args) {
        hollowrhombus(5);
    }
    public static void hollowrhombus(int n){
            for(int i=1;i<=n;i++){
                //spaces
                for(int j=1;j<=(n-i);j++){
                    System.out.print(" ");
                }
                //hollow rhombus is just like hollow rectangle stars will be printed in cross-manner due to reduce in spaces everytime
                for(int j=1;j<=n;j++){
                    if(i==1||i==n||j==1||j==n){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                //first for loop to print line
                System.out.println();
            }
        }
}
