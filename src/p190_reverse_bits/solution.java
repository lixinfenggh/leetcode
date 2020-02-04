package p190_reverse_bits;

import java.util.Arrays;

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }
        int[] bits = new int[32];
        int index = 0;
        while (n > 0) {
            bits[index] = n % 2;
            n = n / 2;
            index ++;
        }
//        System.out.println(Arrays.toString(bits));
        // 负数取补码
        if (isNegative) {
            for (int i = 0; i < 32; i++)
                bits[i] = 1 - bits[i];
            bits[0] = bits[0] + 1;
            for (int i = 0; i < 31; i++) {
                if (bits[i] > 1) {
                    bits[i] = 0;
                    bits[i+1] = bits[i+1] + 1;
                }
            }
            bits[31] = 1;
        }

//        System.out.println(Arrays.toString(bits));
        int result = 0;
        int base = 1;
        for (int i = 31; i >= 0; i--) {
            result = result+ bits[i] * base;
            base = base * 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(-3));
    }
}