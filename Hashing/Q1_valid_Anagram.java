import java.util.*;

public class Q1_valid_Anagram {

    public static boolean isAnagram(String str1, String str2) {
        // when both of the strings have different lengths
        if (str1.length() != str2.length()) return false;
    
        int[] freq = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a']++; 
            /*-97 is done because ASCII value of 'a' = 97 as we need to store frequency of 
            'a','b','c'.... in freq[0],freq[1],freq[2].... we substract from 97
            */
        }
        for (int i = 0; i < str2.length(); i++) {
            freq[str2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = new String();
        String t = new String();
        s = "anagram";
        t = "nagaram";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram("car", "tar"));
    }
}
