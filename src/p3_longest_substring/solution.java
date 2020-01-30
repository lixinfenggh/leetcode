package p3_longest_substring;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int size = s.length();
        int start = 0;
        Map<Character, Integer> charIndex = new HashMap<>();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            Integer index = charIndex.get(c);
            if (index != null && index+1 > start) {
                start = index + 1;
            }
            charIndex.put(c, i);

            if (i - start + 1 > max) {
                max = i - start + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abbc"));
    }
}