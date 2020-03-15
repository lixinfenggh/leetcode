package p5_longest_palindromic_substring;

class Solution {
    private int palindromicSubstringLength(String s, int index) {
        int l1, l2;
        int shift = 1;
        while (index+shift < s.length() && index-shift >= 0) {
            if (s.charAt(index+shift) == s.charAt(index-shift))
                shift++;
            else
                break;;
        }
        l1 = shift * 2 - 1;
        shift = 0;
        while (index+shift+1 < s.length() && index-shift >= 0) {
            if (s.charAt(index+shift+1) == s.charAt(index-shift))
                shift++;
            else
                break;;
        }
        l2 = shift * 2;
        return Math.max(l1, l2);
    }

    public String longestPalindrome(String s) {
        if (s.equals("")) return "";
        int longest = 0, start=0;
        for (int i = 0; i < s.length(); i++) {
            int l =  palindromicSubstringLength(s, i);
            if (l > longest) {
                start = i;
                longest = l;
            }
        }
        if (longest % 2 == 0)
            start = start - longest/2 + 1;
        else
            start = start - longest/2;
        return s.substring(start, start+longest);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abc"));
    }
}