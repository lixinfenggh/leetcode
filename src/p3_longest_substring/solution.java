package p3_longest_substring;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> longestSubstring = new LinkedList<>();
        Queue<Character> checkedSubstring = new LinkedList<>();
        Map<Character, Integer> checkedMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = checkedMap.get(c);
            if (index == null) {
                checkedMap.put(c, checkedSubstring.size());
                checkedSubstring.offer(c);
                if (checkedSubstring.size() > longestSubstring.size()) {
                    longestSubstring = new LinkedList<>(checkedSubstring);
                }
            } else {
                while (checkedSubstring.peek() == null || c != checkedSubstring.peek()) {
                    checkedMap.remove(checkedSubstring.poll());
                }
                checkedSubstring.poll();
                checkedSubstring.offer(c);
            }
        }

        return longestSubstring.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwb"));
    }
}