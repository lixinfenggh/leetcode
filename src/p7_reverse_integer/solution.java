package p7_reverse_integer;

import java.math.BigInteger;

class Solution {
    public int reverse(int x) {
        int absX = Math.abs(x);
        String stringX = Integer.toString(absX);
        StringBuilder reverseStringX = new StringBuilder();
        for (int i = stringX.length()-1; i >= 0; i--) {
            reverseStringX.append(stringX.charAt(i));
        }
        try {
            if (x < 0)
                return -Integer.parseInt(reverseStringX.toString());
            else
                return Integer.parseInt(reverseStringX.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(1534236469));
    }
}