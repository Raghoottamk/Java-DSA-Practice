/* --QUESTION--
    Given a string, we have to find out all its subsequences of it. A String is a subsequence of a given String, that is generated by deleting some character of a given string without changing its order.

   --EXAMPLE--
    Input : abc
    Output : a, b, c, ab, bc, ac, abc

   --LINK--
    https://www.geeksforgeeks.org/print-subsequences-string/
 */
public class Q1_Find_subsets {
    public static void findSubsets(String str,String ans,int i){
        //base
        if(i == str.length()){//a string needs to be printed only when i==3 i.e. last stage in the recursion tree
            if(ans.length() == 0){
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }
        //work
        //choice 1: Yes, an element opts to be a part of substring/subset 
        findSubsets(str,ans+str.charAt(i), i+1);
        //choice 2: No, an element does not opt to be a part of substring/subset
        // then no adding to the string while only 'i' is supposed to be incresed
        findSubsets(str, ans, i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str,"",0);
    }
}
