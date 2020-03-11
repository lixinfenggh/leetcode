package p1013_partition_array_into_three_parts_with_equal_sum;

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A.length < 3) return false;
        int sum = 0;
        for (int a: A)
            sum += a;
        if (sum % 3 != 0) return false;
        int oneThird = sum / 3;
        int tmp = 0;
        int times = 0;
        for (int a: A) {
            tmp += a;
            if (tmp == oneThird) {
                tmp = 0;
                times++;
                if (times > 2)  return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
    }
}