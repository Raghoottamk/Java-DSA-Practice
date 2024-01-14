public class Q_4_find_first_occurance_of_string {
/*
--Question--
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
    class Solution {
        public int strStr(String haystack, String needle) {
            if(needle.length() > haystack.length()) return -1;

            char ch = needle.charAt(0);
            int n = needle.length();
            int n1 = haystack.length();
            for(int i = 0; i <= haystack.length() - n;i++){
                if(haystack.charAt(i) == ch){
                    if(haystack.substring(i,i+n).equals(needle)) return i;
                }
            }
            return -1;
        }
    }
}