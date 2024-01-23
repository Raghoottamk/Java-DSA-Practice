import java.util.List;
/*
You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.

 */
public class Q5_max_len_string_concatenation {
    class Solution {
        
        public int maxLength(List<String> arr) {
            return recur(arr,"",arr.size()-1);
        }

        private int recur(List<String>arr,String ans,int idx){
            if(idx == -1) return ans.length();

            int pick = 0;
            if(check_pick(ans,arr.get(idx))){
                pick = recur(arr,ans + arr.get(idx),idx - 1);
            }
            int not_pick = recur(arr,ans,idx-1); 

            return Math.max(pick,not_pick);
        }

        private boolean check_pick(String ans,String select){
            int[] hash = new int[26];

            for(var ch : ans.toCharArray()){
                if(hash[ch - 'a'] == 1){
                    return false;
                }
                else{
                    hash[ch - 'a']++;
                }
            }
            for(var ch : select.toCharArray()){
                if(hash[ch - 'a'] == 1){
                    return false;
                }
                else{
                    hash[ch - 'a']++;
                }
            }
            return true;
        }
    }
}