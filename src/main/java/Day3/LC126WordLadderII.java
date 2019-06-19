package Day3;

import java.util.*;

public class LC126WordLadderII {
    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
     *
     * Only one letter can be changed at a time
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     *
     * Return an empty list if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     *
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output:
     * [
     *   ["hit","hot","dot","dog","cog"],
     *   ["hit","hot","lot","log","cog"]
     * ]
     */

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0) {
            return res;
        }

        int curNum = 1;
        int nextNum = 0;
        boolean found = false;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> unvisited = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();

        HashMap<String, List<String>> map = new HashMap<>();

        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String newWord = builder.toString();
                    if (unvisited.contains(newWord)) {
                        if (visited.add(newWord)) {
                            nextNum++;
                            queue.offer(newWord);
                        }
                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(word);
                            map.put(newWord, list);
                        }
                        if (newWord.equals(endWord)) {
                            found = true;
                        }
                    }
                }
            }
            if (curNum == 0) {
                if (found) {
                    break;
                }
                curNum = nextNum;
                nextNum = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }
        dfs(res, new ArrayList<>(), map, endWord, beginWord);
        return res;
    }

    public void dfs(List<List<String>> res, List<String> list, HashMap<String, List<String>> map, String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            res.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }

        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                dfs(res, list, map, s, start);
            }
        }
        list.remove(0);
    }
}
