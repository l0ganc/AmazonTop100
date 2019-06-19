package Day4;

public class LC242ValidAnagram {
    /**
     *
     Given two strings s and t , write a function to determine if t is an anagram of s.

     Example 1:

     Input: s = "anagram", t = "nagaram"
     Output: true
     Example 2:

     Input: s = "rat", t = "car"
     Output: false
     */

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
