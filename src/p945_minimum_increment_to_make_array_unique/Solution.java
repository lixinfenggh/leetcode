package p945_minimum_increment_to_make_array_unique;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A.length < 2) return 0;
        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));
        int result = 0;
        int buf = 0;
        for (int i = 1; i < A.length; i++) {
            int gap = A[i] - A[i-1];
            if (gap == 0) {
                buf ++;
                result += buf;
            } else if (gap == 1) {
                result += buf;
            } else {
                {
                    // 因为已经按序排了，所以不会出现gap<0
                    if (buf > gap-1) {
                        buf -= (gap-1);
                        result += buf;
                    } else {
                        buf = 0;
                    }
                }
            }
        }
//        result += (1+buf) * buf / 2;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minIncrementForUnique(new int[]{7,2,7,2,1,4,3,1,4,8}));
//        System.out.println(new Solution().minIncrementForUnique(new int[]{1, 1, 1, 1}));
    }
}