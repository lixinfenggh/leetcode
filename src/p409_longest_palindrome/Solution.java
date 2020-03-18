package p409_longest_palindrome;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> a= new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!a.containsKey(s.charAt(i))) {
                a.put(s.charAt(i), 1);
            } else {
                a.put(s.charAt(i), a.get(s.charAt(i))+1);
            }
        }
        boolean middle = false;
        int len = 0;
        for (Map.Entry<Character, Integer>entry: a.entrySet()) {
            if (!middle && entry.getValue() % 2 == 1) {
                middle = true;
            }
            len += entry.getValue() / 2 * 2;
        }
        return len + (middle ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abccccdd"));
    }
}