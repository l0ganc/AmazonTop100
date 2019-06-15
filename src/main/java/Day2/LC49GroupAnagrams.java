package Day2;

import java.util.*;

public class LC49GroupAnagrams {
    /**
     *
         Given an array of strings, group anagrams together.

         Example:

         Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
         Output:
         [
         ["ate","eat","tea"],
         ["nat","tan"],
         ["bat"]
         ]
     */

    // time = O(NKlogK)
    // space = O(NK)  where N is the length of strs and K is the maximum length of a string in strs
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temp = String.valueOf(arr);
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(s);
        }

        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
