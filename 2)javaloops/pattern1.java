public class pattern1 {
    public static void main(String[] args) {
        for(int line=1;line<=4;line++){
            for(int star=1;star<=line;star++){
                System.out.print("*");//dont use println here
            }
            System.out.println();//its in outer loop(first loop) and prints the no. of lines
        }
    }
}
