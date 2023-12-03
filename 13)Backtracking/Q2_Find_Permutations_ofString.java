/*  --LINK--
    https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

    IN THE ABOVE LINK OF GEEK FOR GEEKS IT HAS MORE OPTIMISED CODE THAN THE BELOW WRITTEN CODE

    --QUESTION--
    Given a string S, the task is to write a program to print all permutations of a given string. 

    NOTE: A permutation also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered list S into a one-to-one correspondence with S itself. A string of length N has N! permutations. 

    --Examples--
    Input: S = “ABC”
    Output: “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”

    Input: S = “XY”
    Output: “XY”, “YX”
*/
public class Q2_Find_Permutations_ofString {
    public static void findPermutations(String str,String ans) {
        //base
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //work
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i+1);
            findPermutations(newstr, ans + curr);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str,"");
    }
}
