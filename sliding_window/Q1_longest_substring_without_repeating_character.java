package sliding_window;

import java.util.HashSet;
import java.util.Set;

/*
--Question--
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.

Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
/*
Approach-
S-1-Use sliding window with hashset, use left and right pointers to move the window .
S-2-If the set doesn't contains character then first add into the set and calculate the maxLength hand-in-hand...
S-3-if character already present in the set that means you have to move your sliding window by 1 , before that you have to remove all the characters that are infront of the character that is present already in window before.
S-4-Now you have to remove that character also and move the left pointer and also add the new character into the set.
 */
public class Q1_longest_substring_without_repeating_character {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character>set = new HashSet<>();
            int max = 0;
            int left = 0;
            for(int right = 0; right < s.length(); right++){
                if(!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    max = Math.max(max,right - left + 1);
                }
                else{
                    while(s.charAt(left) != s.charAt(right)){
                        set.remove(s.charAt(left));
                        left++;
                    }
                    set.remove(s.charAt(left));
                    left++;
                    set.add(s.charAt(right));
                }
            }
            return max;
        }
    }
}
