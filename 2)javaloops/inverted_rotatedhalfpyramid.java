public class inverted_rotatedhalfpyramid {
    public static void main(String[] args) {
        int n = 4;
        char ch = '*';
        for(int line=1;line<=n;line++){
            for(int bs=1;bs<= n-line;bs++){
                System.out.print(bs*' ');
                System.out.print(line*ch);
            }
            System.out.println();
        } 
    }
}
