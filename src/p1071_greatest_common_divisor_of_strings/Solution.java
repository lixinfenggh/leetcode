package p1071_greatest_common_divisor_of_strings;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == len2) {
            if (str1.equals(str2))
                return str1;
            else
                return "";
        }
        if (len2 > len1) {
            return gcdOfStrings(str1, str2.substring(len1));
        } else {
            return gcdOfStrings(str2, str1.substring(len2));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("ABABABABc", "ABABABABABAB"));
    }
}