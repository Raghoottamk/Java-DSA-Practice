import java.util.HashMap;
import java.util.Map;

public class Q1_valid_Anagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if (!map1.containsKey(ch)) {
                map1.put(ch, 1);
            } else {
                map1.put(ch, map1.get(ch) + 1);
            }
        }
        for(int i = 0;i < t.length();i++){
            char ch = t.charAt(i);
            if (!map2.containsKey(ch)) {
                map2.put(ch, 1);
            } else {
                map2.put(ch, map2.get(ch) + 1);
            }
        }

        return map1.equals(map2);
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
