package p365_water_and_jug_problem;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        if (x == 0 || y == 0) return z == x || z == y;
        int big = Math.max(x, y);
        int small = Math.min(x, y);
        int remain = big - small;
        while (remain > 0) {
            big = Math.max(remain, small);
            small = Math.min(remain, small);
            remain = big - small;
        }
        return z % small == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater(2, 6, 5));
    }
}