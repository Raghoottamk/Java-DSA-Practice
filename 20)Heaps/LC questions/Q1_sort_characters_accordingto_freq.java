/*
--Question--
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */
import java.util.*;

class Pair{
    char first;
    int second;
    Pair(char ch,int val){
        this.first = ch;
        this.second = val;
    }
}
public class Q1_sort_characters_accordingto_freq {
    //solution using comparator to create reverse ordered PQ
    class Solution {
        public String frequencySort(String s) {
            Map<Character,Integer> map = new HashMap<>();
            for(var ch : s.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0) + 1);
            }
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
                        public int compare(Pair a,Pair b)
                        {
                            if (a.second < b.second)
                                return 1;
                            if (a.second > b.second)
                                return -1;
                            return 0;
                        }
                    });
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                maxHeap.add(new Pair(entry.getKey(),entry.getValue()));
            }
            while(!maxHeap.isEmpty()){
                Pair curr = maxHeap.remove();
                for(int i = 0; i < curr.second ; i++){
                    sb.append(curr.first);
                }
            }
            return String.valueOf(sb);
        }
        //using lamda expression to convert PQ in reverse order
        class Solution2 {
            public String frequencySort(String s) {
                Map<Character,Integer> map = new HashMap<>();
                for(var ch : s.toCharArray()){
                    map.put(ch,map.getOrDefault(ch,0) + 1);
                }
                PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1,p2) -> p2.second - p1.second);
                StringBuilder sb = new StringBuilder();
                for(Map.Entry<Character,Integer> entry : map.entrySet()){
                    maxHeap.add(new Pair(entry.getKey(),entry.getValue()));
                }
                while(!maxHeap.isEmpty()){
                    Pair curr = maxHeap.remove();
                    for(int i = 0; i < curr.second ; i++){
                        sb.append(curr.first);
                    }
                }
                return String.valueOf(sb);
            }
        }

        //using comparator.reverseOrder();
        class Pair implements Comparable<Pair>{
            char first;
            int second;
            public Pair(char first,int second){
                this.first = first;
                this.second = second;
            }
            @Override
            public int compareTo(Pair s2){
                return this.second - s2.second;
                //return this.name.compareTo(s2.name);//to compare names lexicographically
            }
        }
        class Solution3 {
            public String frequencySort(String s) {
                Map<Character,Integer> map = new HashMap<>();
                for(var ch : s.toCharArray()){
                    map.put(ch,map.getOrDefault(ch,0) + 1);
                }
                PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
                StringBuilder sb = new StringBuilder();
                for(Map.Entry<Character,Integer> entry : map.entrySet()){
                    maxHeap.add(new Pair(entry.getKey(),entry.getValue()));
                }
                while(!maxHeap.isEmpty()){
                    Pair curr = maxHeap.remove();
                    for(int i = 0; i < curr.second ; i++){
                        sb.append(curr.first);
                    }
                }
                return String.valueOf(sb);
            }
        }
    }
}
