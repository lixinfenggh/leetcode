package p14_longest_common_prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int maxIndex = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            maxIndex = Integer.min(maxIndex, strs[i].length());
            for (int j = 0; j < maxIndex; j++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    maxIndex = j;
                    break;
                }
            }
        }

        return strs[0].substring(0, maxIndex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"aa", "a"}));
    }
}