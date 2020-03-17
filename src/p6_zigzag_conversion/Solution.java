package p6_zigzag_conversion;

class Solution {
    public String convert(String s, int numRows) {
        if (s.equals("")) return "";
        if (numRows == 1) return s;
        if (numRows == 0) return "";
        StringBuilder result = new StringBuilder();
        // 第一行
        int row = 0, col=0, index = 0;
        while (index < s.length()) {
            result.append(s.charAt(index));
            col++;
            index = 2 * (numRows-1) * col;
        }
        while (++row < numRows-1) {
            col = 0;
            index = 2*(numRows-1)*col+row;
            while (index < s.length()) {
                result.append(s.charAt(index));
                index = 2*(numRows-1)*(col+1)-row;
                if (index < s.length())
                    result.append(s.charAt(index));
                col++;
                index = 2*(numRows-1)*col+row;
            }
        }
        col = 0;
        index = 2*(numRows-1)*col+row;
        while (index < s.length()) {
            result.append(s.charAt(index));
            col ++;
            index = 2*(numRows-1)*col+row;
        }
        // 最后一行
        return result.toString();
    }

    public static void main(String[] args) {
        String result = new Solution().convert("A", 1);
        System.out.println(result);
        System.out.println("A".equals(result));
    }
}