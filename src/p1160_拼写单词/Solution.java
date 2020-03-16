package p1160_拼写单词;

import java.util.Arrays;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charNums = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charNums[(int) chars.charAt(i)-97]++;
        }
        int sum = 0;
        for (String word : words) {
            boolean isIn = true;
            for (int j = 0; j < word.length(); j++) {
                charNums[(int) word.charAt(j) - 97]--;
                if (charNums[(int) word.charAt(j) - 97] < 0) {
                    isIn = false;
                }
            }
            if (isIn) {
                sum += word.length();
            }
            for (int j = 0; j < word.length(); j++) {
                charNums[(int) word.charAt(j) - 97]++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countCharacters(new String[]{
                "hello", "world", "leetcode"
        }, "welldonehoneyr"));
    }
}