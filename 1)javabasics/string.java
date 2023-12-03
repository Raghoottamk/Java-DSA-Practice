public class string {
    public static void main(String[] args) {
        
        String s1 = "      RagH   ooTtam   ";
        System.out.println("1"+s1.length());
        System.out.println("2"+s1.toLowerCase());
        System.out.println("3"+s1.toUpperCase());
        System.out.println("4"+s1.trim());//trims only starting and after the string not the spaces in middle of the characters
        System.out.println("5"+s1.substring(1));
        System.out.println("6"+s1.substring(1,3));
        System.out.println("7"+s1.replace('R','g'));
        //s1 = s1.toLowerCase();//works without any problem
        //System.out.println(s1);
        

    }
}
