public class Q3_binary_strings {
    /*Q-print all binary strings of size 'n' without consecutive ones */
    /*
     https://www.geeksforgeeks.org/generate-binary-strings-without-consecutive-1s/ 
    */
    /* EXPLAINATION
    Idea behind that is IF string ends with ‘1’ then we put only ‘0’ at the end. IF string ends with ‘0’ then we put both ‘0’ and ‘1’ at the end of string for generating new string. 
    */
    /* SAMPLE INPUT
    Input : n = 3  
    Output : 000 , 001 , 010 , 100 , 101 
    Input : n  = 4 
    Output :0000 0001 0010 0100 0101 1000 1001 1010 
    */
    public static void printString(int n,int lastDigit,String str){
        //base
        if(n==0){
            System.out.println(str);
            return;
        }
        //work
        printString(n-1,0, str + "0"); //not += coz we need to remove it later
        if(lastDigit==0){
            printString(n-1,1, str + "1");
        }
        // if(lastDigit == 0){
        //     printString(n-1,0, str);
        //     printString(n-1,1, str);
        // }
        // else{
        //     printString(n-1,0, str);
        // }

    }
    public static void main(String[] args) {
        String str = new String("");
        printString(3, 0,str);
    }
}
