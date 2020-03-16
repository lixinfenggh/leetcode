package compress_string_lcci;

class Solution {
    public String compressString(String S) {
        if (S.equals("")) return "";
        StringBuilder result = new StringBuilder();
        char tmp=S.charAt(0);
        Integer count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == tmp) {
                count++;
            } else {
                result.append(tmp);
                result.append(count);
                count = 1;
                tmp = S.charAt(i);
            }
        }
        result.append(tmp);
        result.append(count);
//        System.out.println(result.toString());
        return result.length() >= S.length() ? S : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compressString("a"));
    }
}