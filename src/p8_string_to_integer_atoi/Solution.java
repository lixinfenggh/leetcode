package p8_string_to_integer_atoi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int myAtoi(String str) {
        // max 2147483647
        // min -2147483648
        // List<Integer> nums = new ArrayList<>();
        String nums = "";
        boolean over0 = true;
        boolean start = false;
        int begin=-1, end=str.length()-1;
        boolean isNum = false;
        for (int i = 0; i < str.length(); i++) {
            isNum = str.charAt(i) >= '0' && str.charAt(i) <= '9';

            if (start) {
                if (!(isNum)) {
                    end = i-1;
                    break;
                }
            } else {
                if (str.charAt(i) == ' ') continue;
                if (str.charAt(i) == '+') {
                    start = true;
                    begin = i + 1;
                } else if (str.charAt(i) == '-') {
                    over0 = false;
                    start = true;
                    begin = i;
                } else if (isNum) {
                    start = true;
                    begin = i;
                } else
                    return 0;
            }
        }

        if (!start || (end == str.length()-1 && !isNum) || end < begin) return 0;
//        System.out.println(begin);
//        System.out.println(end);
//        System.out.println(str.substring(begin, end+1));

        try {
            String result = str.substring(begin, end+1);
            if (result.equals("-")) return 0;
            return Integer.parseInt(result);
        } catch (Exception e) {
            if (over0) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi(" -+1"));
    }
}