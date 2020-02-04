package p7_reverse_integer;

import java.math.BigInteger;

class Solution {
    public int reverse(int x) {
        try {
            int max10 = Integer.MAX_VALUE / 10;
            int max1 = Integer.MAX_VALUE % 10;
            boolean isNegative = false;
            if (x < 0) {
                isNegative = true;
                x = -x;
            }
            int result = 0;
            while (x > 0) {
                int mod = x % 10;
                if (result > max10 || (result == max10 && mod > max1))
                    return 0;
                result = result * 10 + mod;
                x = x / 10;
            }
            return isNegative ? -result : result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(1534236469));
    }
}